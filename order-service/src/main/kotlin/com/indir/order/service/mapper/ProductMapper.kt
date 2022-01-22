package com.indir.order.service.mapper

import com.indir.order.service.dto.ProductDto
import com.indir.order.service.entity.Product

class ProductMapper {
    companion object {
        fun toDto(product: Product): ProductDto =
            ProductDto(id = product.id, name = product.name, quantity = product.quantity, lastUpdated = product.lastUpdated)
    }
}