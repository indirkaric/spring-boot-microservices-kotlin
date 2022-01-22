package com.indir.customer.service.controller

import com.indir.customer.service.dto.CountryDto
import com.indir.customer.service.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/countries/")
class CountryController {
    @Autowired
    lateinit var countryService: CountryService

    @GetMapping
    fun getCountries(): ResponseEntity<List<CountryDto>> = ResponseEntity(countryService.getCountries(), HttpStatus.OK)
}