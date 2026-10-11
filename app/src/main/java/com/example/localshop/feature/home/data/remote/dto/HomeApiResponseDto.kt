package com.example.localshop.feature.home.data.remote.dto

import com.example.localshop.feature.category.data.remote.dto.CategoryDto
import com.example.localshop.feature.product.data.remote.dto.ProductDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeApiResponseDto(
    @SerialName("banners")
    val banners: List<BannerDto> = emptyList(),

    @SerialName("products")
    val products: List<ProductDto> = emptyList(),

    @SerialName("categories")
    val categories: List<CategoryDto> = emptyList(),

    @SerialName("latest_products")
    val latestProducts: List<ProductDto> = emptyList(),

    @SerialName("featured_products")
    val featuredProducts: List<ProductDto> = emptyList()
)
