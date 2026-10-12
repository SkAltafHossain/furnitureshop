package com.altaf.furnitureshop.feature.category.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.category.domain.model.Category
import com.altaf.furnitureshop.feature.category.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryDetailsUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(categoryId: Int): Flow<ResultState<Category>> {
        return repository.getCategoryDetails(categoryId)
    }
}