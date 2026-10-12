package com.altaf.furnitureshop.feature.category.data.repository

import com.altaf.furnitureshop.core.error.ErrorMapper
import com.altaf.furnitureshop.core.result.PagedResult
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.category.data.mapper.CategoryMapper
import com.altaf.furnitureshop.feature.category.data.mapper.CategoryWithProductsMapper
import com.altaf.furnitureshop.feature.category.data.remote.CategoryApi
import com.altaf.furnitureshop.feature.category.domain.model.Category
import com.altaf.furnitureshop.feature.category.domain.model.CategoryWithProducts
import com.altaf.furnitureshop.feature.category.domain.repository.CategoryRepository
import com.altaf.furnitureshop.feature.product.data.mapper.ProductMapper
import com.altaf.furnitureshop.feature.product.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryApi: CategoryApi
) : CategoryRepository {
    
    override fun getCategories(): Flow<ResultState<List<Category>>> = flow {
        emit(ResultState.Loading)
        try {
            val response = categoryApi.getCategories()
            if (response.success && response.data != null) {
                val categories = CategoryMapper.mapToDomainList(response.data)
                emit(ResultState.Success(categories))
            } else {
                emit(ResultState.Error(response.message ?: "Operation failed"))
            }
        } catch (e: Exception) {
            val appError = ErrorMapper.mapToAppError(e)
            emit(ResultState.Error(appError.localizedMessage ?: appError.toString(), appError))
        }
    }
    
    override fun getCategoryDetails(categoryId: Int): Flow<ResultState<Category>> = flow {
        emit(ResultState.Loading)
        try {
            val response = categoryApi.getCategoryDetails(categoryId)
            if (response.success && response.data != null) {
                val category = CategoryMapper.mapToDomain(response.data)
                emit(ResultState.Success(category))
            } else {
                emit(ResultState.Error(response.message ?: "Operation failed"))
            }
        } catch (e: Exception) {
            val appError = ErrorMapper.mapToAppError(e)
            emit(ResultState.Error(appError.localizedMessage ?: appError.toString(), appError))
        }
    }
    
    override fun getCategoryProducts(categoryId: Int, perPage: Int): Flow<ResultState<PagedResult<Product>>> = flow {
        emit(ResultState.Loading)
        try {
            val response = categoryApi.getCategoryProducts(categoryId, perPage)
            if (response.success) {
                val products = ProductMapper.mapToDomainList(response.data)
                val pagedResult = PagedResult(
                    items = products,
                    currentPage = response.pagination.currentPage,
                    lastPage = response.pagination.lastPage,
                    total = response.pagination.total,
                    perPage = response.pagination.perPage,
                    from = response.pagination.from,
                    to = response.pagination.to
                )
                emit(ResultState.Success(pagedResult))
            } else {
                emit(ResultState.Error(response.message ?: "Operation failed"))
            }
        } catch (e: Exception) {
            val appError = ErrorMapper.mapToAppError(e)
            emit(ResultState.Error(appError.localizedMessage ?: appError.toString(), appError))
        }
    }
    
    override fun getCategoryWithProducts(categoryId: Int, perPage: Int): Flow<ResultState<CategoryWithProducts>> = flow {
        emit(ResultState.Loading)
        try {
            val response = categoryApi.getCategoryWithProducts(categoryId, perPage)
            if (response.success && response.data != null) {
                val categoryWithProducts = CategoryWithProductsMapper.mapToDomain(response.data)
                emit(ResultState.Success(categoryWithProducts))
            } else {
                emit(ResultState.Error(response.message ?: "Operation failed"))
            }
        } catch (e: Exception) {
            val appError = ErrorMapper.mapToAppError(e)
            emit(ResultState.Error(appError.localizedMessage ?: appError.toString(), appError))
        }
    }
}