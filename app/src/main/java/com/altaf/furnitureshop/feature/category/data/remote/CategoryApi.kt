package com.altaf.furnitureshop.feature.category.data.remote

import com.altaf.furnitureshop.core.network.ApiResponse
import com.altaf.furnitureshop.core.network.PaginatedResponse
import com.altaf.furnitureshop.feature.category.data.remote.dto.CategoryDto
import com.altaf.furnitureshop.feature.category.data.remote.dto.CategoryWithProductsDto
import com.altaf.furnitureshop.feature.product.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryApi {
    @GET("categories")
    suspend fun getCategories(): ApiResponse<List<CategoryDto>>
    
    @GET("categories/{id}")
    suspend fun getCategoryDetails(@Path("id") categoryId: Int): ApiResponse<CategoryDto>
    
    @GET("categories/{id}/products")
    suspend fun getCategoryProducts(
        @Path("id") categoryId: Int,
        @Query("per_page") perPage: Int = 12
    ): PaginatedResponse<ProductDto>
    
    @GET("categories/{id}/products")
    suspend fun getCategoryWithProducts(
        @Path("id") categoryId: Int,
        @Query("per_page") perPage: Int = 12
    ): ApiResponse<CategoryWithProductsDto>
}