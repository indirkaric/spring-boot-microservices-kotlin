package com.indir.customer.service.mapper

import com.indir.customer.service.dto.CityDto
import com.indir.customer.service.entity.City

class CityMapper {
    companion object {
        fun toDto(city: City): CityDto = CityDto(id = city.id, name = city.name)
    }
}