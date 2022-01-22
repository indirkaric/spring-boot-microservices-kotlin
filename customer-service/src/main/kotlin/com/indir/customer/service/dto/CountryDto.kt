package com.indir.customer.service.dto

data class CountryDto (
    var id: Long,
    var name: String,
    var cities: MutableList<CityDto>
)