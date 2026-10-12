package com.altaf.furnitureshop.feature.cart.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.cart.domain.model.BuyNowData
import com.altaf.furnitureshop.feature.cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BuyNowUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(productId: Int, quantity: Int = 1): Flow<ResultState<BuyNowData>> {
        return cartRepository.buyNow(productId, quantity)
    }
}
