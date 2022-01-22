package com.indir.customer.service.mapper

import com.indir.customer.service.dto.CityDto
import com.indir.customer.service.dto.CountryDto
import com.indir.customer.service.entity.Country

class CountryMapper {
    companion object {
        fun toDto(country: Country): CountryDto {
            val cities = mutableListOf<CityDto>()
            country.cities.forEach { city -> cities.add(CityMapper.toDto(city)) }
            return CountryDto(id = country.id, name = country.name, cities = cities)
        }
    }
}