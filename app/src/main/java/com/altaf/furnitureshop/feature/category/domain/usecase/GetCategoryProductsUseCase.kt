package com.altaf.furnitureshop.feature.category.domain.usecase

import com.altaf.furnitureshop.core.result.PagedResult
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.category.domain.repository.CategoryRepository
import com.altaf.furnitureshop.feature.product.domain.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryProductsUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(categoryId: Int, perPage: Int = 12): Flow<ResultState<PagedResult<Product>>> {
        return repository.getCategoryProducts(categoryId, perPage)
    }
}