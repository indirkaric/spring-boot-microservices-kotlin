package com.indir.order.service.service

import com.indir.order.service.dto.ProductDto
import com.indir.order.service.mapper.ProductMapper
import com.indir.order.service.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    fun getProducts(): List<ProductDto> = productRepository.findAll().map { product -> ProductMapper.toDto(product) }
}