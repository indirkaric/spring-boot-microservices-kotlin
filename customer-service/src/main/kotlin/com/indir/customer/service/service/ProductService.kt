package com.indir.customer.service.service

import com.indir.customer.service.dto.ProductDto
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder


@Service
class ProductService {
    val BASE_URL = "http://localhost:8085/order-service/api/v1/products/"

    fun getProducts(): List<ProductDto> {
        val finalURI = UriComponentsBuilder.fromHttpUrl(BASE_URL)
            .build()
            .encode()
            .toUri()

        val restTemplate = RestTemplate()
        val response = restTemplate.getForEntity(finalURI, Array<ProductDto>::class.java)
        return response.body?.toList() ?: mutableListOf()
    }

    fun getProductsFault() : List<ProductDto> = mutableListOf()
}