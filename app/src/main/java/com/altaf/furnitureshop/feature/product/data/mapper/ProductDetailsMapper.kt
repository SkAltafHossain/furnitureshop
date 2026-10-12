package com.altaf.furnitureshop.feature.product.data.mapper

import com.altaf.furnitureshop.feature.product.data.remote.dto.ProductDetailsDto
import com.altaf.furnitureshop.feature.product.domain.model.ProductDetails

object ProductDetailsMapper {
    fun mapToDomain(dto: ProductDetailsDto): ProductDetails {
        return ProductDetails(
            product = ProductMapper.mapToDomain(dto.product),
            relatedProducts = dto.relatedProducts.map { ProductMapper.mapToDomain(it) }
        )
    }
}