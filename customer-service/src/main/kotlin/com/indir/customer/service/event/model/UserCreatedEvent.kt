package com.indir.customer.service.event.model

class UserCreatedEvent(
    var id: Long,
    var firstName: String,
    var lastName: String,
    var username: String,
    var cityId: Long,
    var customerId: Long
) : Event()