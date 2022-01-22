package com.indir.order.service

import com.indir.order.service.event.Channel
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.integration.config.EnableIntegration

@SpringBootApplication
@EnableBinding(Channel::class)
@EnableIntegration
class OrderServiceApplication

fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args)
}
