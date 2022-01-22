package com.indir.customer.service.entity

import javax.persistence.*

@Entity
@Table(name = "countries")
data class Country (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(unique = true)
    var name: String,

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "country")
    var cities: MutableList<City> = mutableListOf<City>()
)
