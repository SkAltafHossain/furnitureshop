package com.altaf.furnitureshop.feature.product.domain.model

data class ProductDetails(
    val product: Product,
    val relatedProducts: List<Product>
)