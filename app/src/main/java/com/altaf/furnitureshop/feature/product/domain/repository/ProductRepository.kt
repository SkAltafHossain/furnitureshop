package com.altaf.furnitureshop.feature.product.domain.repository

import com.altaf.furnitureshop.core.result.PagedResult
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.product.domain.model.Product
import com.altaf.furnitureshop.feature.product.domain.model.ProductDetails
import com.altaf.furnitureshop.feature.product.domain.model.ProductFilters
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(filters: ProductFilters): Flow<ResultState<PagedResult<Product>>>
    fun getProductDetails(productId: Int): Flow<ResultState<Product>>
    fun getProductWithRelated(productId: Int): Flow<ResultState<ProductDetails>>
    fun searchProducts(query: String, perPage: Int): Flow<ResultState<PagedResult<Product>>>
    fun getFeaturedProducts(perPage: Int): Flow<ResultState<PagedResult<Product>>>
    fun getLatestProducts(perPage: Int): Flow<ResultState<PagedResult<Product>>>
}