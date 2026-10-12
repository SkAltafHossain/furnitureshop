package com.altaf.furnitureshop.feature.category.domain.repository

import com.altaf.furnitureshop.core.result.PagedResult
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.category.domain.model.Category
import com.altaf.furnitureshop.feature.category.domain.model.CategoryWithProducts
import com.altaf.furnitureshop.feature.product.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories(): Flow<ResultState<List<Category>>>
    fun getCategoryDetails(categoryId: Int): Flow<ResultState<Category>>
    fun getCategoryProducts(categoryId: Int, perPage: Int): Flow<ResultState<PagedResult<Product>>>
    fun getCategoryWithProducts(categoryId: Int, perPage: Int): Flow<ResultState<CategoryWithProducts>>
}