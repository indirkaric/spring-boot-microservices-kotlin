package com.indir.order.service.controller

import com.indir.order.service.dto.ProductDto
import com.indir.order.service.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products/")
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun getProducts(): ResponseEntity<List<ProductDto>> = ResponseEntity(productService.getProducts(), HttpStatus.OK)
}