package com.altaf.furnitureshop.feature.cart.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateCartItemUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(cartItemId: Int, quantity: Int): Flow<ResultState<Unit>> {
        return cartRepository.updateCartItem(cartItemId, quantity)
    }
}
