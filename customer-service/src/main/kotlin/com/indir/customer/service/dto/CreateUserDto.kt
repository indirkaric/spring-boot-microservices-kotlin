package com.indir.customer.service.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateUserDto(
    @NotBlank(message = "First name can not be blank")
    var firstName: String,

    @NotBlank(message = "Last name can not be blank")
    var lastName: String,

    @NotBlank(message = "username can not be blank")
    var username: String,

    @NotNull(message = "city id can not be blank")
    var cityId: Long
)