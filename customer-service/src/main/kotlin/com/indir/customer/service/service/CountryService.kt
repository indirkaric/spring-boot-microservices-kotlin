package com.indir.customer.service.service

import com.indir.customer.service.dto.CountryDto
import com.indir.customer.service.mapper.CountryMapper
import com.indir.customer.service.repository.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService {

    @Autowired
    lateinit var countryRepository: CountryRepository

    fun getCountries(): List<CountryDto> = countryRepository.findAll().map { country -> CountryMapper.toDto(country) }
}