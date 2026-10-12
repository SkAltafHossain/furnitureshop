package com.altaf.furnitureshop.feature.category.domain.model

import com.altaf.furnitureshop.feature.product.domain.model.Product

data class CategoryWithProducts(
    val category: Category,
    val products: List<Product>
)