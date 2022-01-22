package com.indir.customer.service.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "cities")
data class City (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(unique = true)
    var name: String,

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    var country: Country
)