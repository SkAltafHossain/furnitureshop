package com.altaf.furnitureshop.feature.checkout.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.checkout.domain.model.CheckoutRequest
import com.altaf.furnitureshop.feature.checkout.domain.model.CheckoutResponse
import kotlinx.coroutines.flow.Flow

interface CheckoutRepository {
    fun processCheckout(request: CheckoutRequest): Flow<ResultState<CheckoutResponse>>
}
