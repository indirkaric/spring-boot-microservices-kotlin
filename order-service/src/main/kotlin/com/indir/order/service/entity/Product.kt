package com.indir.order.service.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(unique = true)
    var name: String,

    @Column(nullable = false)
    var quantity: Int,

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var lastUpdated: Date = Date()
)