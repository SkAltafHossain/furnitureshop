package com.altaf.furnitureshop.feature.product.domain.usecase

import com.altaf.furnitureshop.core.result.PagedResult
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.product.domain.model.Product
import com.altaf.furnitureshop.feature.product.domain.model.ProductFilters
import com.altaf.furnitureshop.feature.product.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(filters: ProductFilters): Flow<ResultState<PagedResult<Product>>> {
        return repository.getProducts(filters)
    }
}