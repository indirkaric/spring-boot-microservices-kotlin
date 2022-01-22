package com.indir.customer.service.service

import com.indir.customer.service.dto.CreateUserDto
import com.indir.customer.service.dto.UserDto
import com.indir.customer.service.entity.Customer
import com.indir.customer.service.entity.User
import com.indir.customer.service.event.model.UserCreatedEvent
import com.indir.customer.service.event.producer.UserCreatedProducer
import com.indir.customer.service.exception.error.BadRequestException
import com.indir.customer.service.exception.error.NotFoundException
import com.indir.customer.service.exception.error.RestApiError
import com.indir.customer.service.mapper.UserMapper
import com.indir.customer.service.repository.CustomerRepository
import com.indir.customer.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var userCreatedProducer: UserCreatedProducer

    @Autowired
    lateinit var cityService: CityService

    fun getUsers(): List<UserDto> = userRepository.findAll().map { user -> UserMapper.toDto(user) }

    fun getUser(id: Long): UserDto = UserMapper.toDto(findById(id))

    fun saveUser(createUserDto: CreateUserDto) {
        val user = userRepository.findByUsername(createUserDto.username)
        if (user != null)
            throw BadRequestException(RestApiError.USER_ALREADY_EXISTS)

        val city = cityService.findById(createUserDto.cityId)
        val savedUser = userRepository.save(UserMapper.toEntity(createUserDto))
        val savedCustomer = customerRepository.save(Customer(city = city, user = savedUser))

        val userCreatedEvent = UserCreatedEvent(id = savedUser.id,
                                                firstName = savedUser.firstName,
                                                lastName = savedUser.lastName,
                                                username = savedUser.username,
                                                cityId = city.id,
                                                customerId = savedCustomer.id)

        userCreatedProducer.publish(userCreatedEvent)
    }

    private fun findById(id: Long): User {
        val user = userRepository.findById(id)
        if (user.isPresent)
            return user.get()
        throw NotFoundException(RestApiError.USER_NOT_FOUND)
    }
}