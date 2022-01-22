package com.indir.order.service.event.consumer


import com.indir.order.service.entity.Customer
import com.indir.order.service.entity.User
import com.indir.order.service.event.model.UserCreatedEvent
import com.indir.order.service.helper.Logger
import com.indir.order.service.repository.CustomerRepository
import com.indir.order.service.repository.UserRepository
import com.indir.order.service.service.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component


@Component
class UserConsumer {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var cityService: CityService

    @StreamListener(target = "messaging-channel", condition = "headers['eventType']=='usercreatedevent'")
    fun listen(event: UserCreatedEvent?) {
        Logger.log.info("Listening UserCreatedEvent {}", event.toString())
        val city = cityService.findById(event!!.cityId)
        val user = User(id = event!!.id,
                        username = event!!.username,
                        firstName = event!!.firstName,
                        lastName = event!!.lastName)
        val savedUser = userRepository.save(user)
        val customer = Customer(id = event!!.customerId, user =  savedUser, city = city)
        customerRepository.save(customer)
    }
}