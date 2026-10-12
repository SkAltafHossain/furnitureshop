package com.altaf.furnitureshop.feature.cart.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClearCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<ResultState<Unit>> {
        return cartRepository.clearCart()
    }
}
