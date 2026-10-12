package com.altaf.furnitureshop.feature.category.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.category.domain.model.CategoryWithProducts
import com.altaf.furnitureshop.feature.category.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryWithProductsUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(categoryId: Int, perPage: Int = 12): Flow<ResultState<CategoryWithProducts>> {
        return repository.getCategoryWithProducts(categoryId, perPage)
    }
}