package com.indir.order.service.event.model

import java.io.Serializable


class UserCreatedEvent(
    var id: Long,
    var firstName: String,
    var lastName: String,
    var username: String,
    var cityId: Long,
    var customerId: Long
) : Serializable