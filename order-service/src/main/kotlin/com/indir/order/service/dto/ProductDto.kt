package com.indir.order.service.dto

import java.io.Serializable
import java.util.*

data class ProductDto (
    var id: Long,
    var name: String,
    var quantity: Int,
    var lastUpdated: Date = Date()
): Serializable