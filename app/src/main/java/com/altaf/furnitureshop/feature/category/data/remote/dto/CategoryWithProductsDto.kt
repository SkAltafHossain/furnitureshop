package com.altaf.furnitureshop.feature.category.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryWithProductsDto(
    @SerialName("category")
    val category: CategoryDto,
    
    @SerialName("products")
    val products: List<com.altaf.furnitureshop.feature.product.data.remote.dto.ProductDto>
)