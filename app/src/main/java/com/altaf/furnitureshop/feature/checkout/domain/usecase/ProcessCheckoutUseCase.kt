package com.altaf.furnitureshop.feature.checkout.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.checkout.domain.model.CheckoutRequest
import com.altaf.furnitureshop.feature.checkout.domain.model.CheckoutResponse
import com.altaf.furnitureshop.feature.checkout.domain.repository.CheckoutRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProcessCheckoutUseCase @Inject constructor(
    private val checkoutRepository: CheckoutRepository
) {
    operator fun invoke(request: CheckoutRequest): Flow<ResultState<CheckoutResponse>> {
        return checkoutRepository.processCheckout(request)
    }
}
