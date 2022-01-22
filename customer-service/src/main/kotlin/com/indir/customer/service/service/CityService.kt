package com.indir.customer.service.service

import com.indir.customer.service.entity.City
import com.indir.customer.service.exception.error.NotFoundException
import com.indir.customer.service.exception.error.RestApiError
import com.indir.customer.service.repository.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CityService {

    @Autowired
    lateinit var cityRepository: CityRepository

    fun findById(id: Long): City {
        val city = cityRepository.findById(id)
        if (city.isPresent)
            return city.get()
        throw NotFoundException(RestApiError.CITY_NOT_FOUND)
    }
}