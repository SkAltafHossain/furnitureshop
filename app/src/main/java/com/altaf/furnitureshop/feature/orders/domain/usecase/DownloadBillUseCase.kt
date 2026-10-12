package com.altaf.furnitureshop.feature.orders.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.orders.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import javax.inject.Inject

class DownloadBillUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    operator fun invoke(orderId: Int): Flow<ResultState<ResponseBody>> {
        return orderRepository.downloadBill(orderId)
    }
}
