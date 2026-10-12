package com.altaf.furnitureshop.feature.home.domain.model

import com.altaf.furnitureshop.feature.category.domain.model.Category
import com.altaf.furnitureshop.feature.product.domain.model.Product

data class HomeData(
    val banners: List<Banner>,
    val products: List<Product>,
    val categories: List<Category>,
    val latestProducts: List<Product>,
    val featuredProducts: List<Product>
)
