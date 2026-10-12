package com.altaf.furnitureshop.feature.product.domain.usecase

import com.altaf.furnitureshop.core.result.PagedResult
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.product.domain.model.Product
import com.altaf.furnitureshop.feature.product.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(query: String, perPage: Int = 12): Flow<ResultState<PagedResult<Product>>> {
        return repository.searchProducts(query, perPage)
    }
}