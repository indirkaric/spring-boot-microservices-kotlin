package com.indir.customer.service.entity

import javax.persistence.*

@Entity
@Table(name = "customers")
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    var city: City
)