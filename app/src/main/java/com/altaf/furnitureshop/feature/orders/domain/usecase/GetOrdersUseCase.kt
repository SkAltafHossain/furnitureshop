package com.altaf.furnitureshop.feature.orders.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.orders.domain.model.Order
import com.altaf.furnitureshop.feature.orders.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOrdersUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    operator fun invoke(): Flow<ResultState<List<Order>>> {
        return orderRepository.getOrders()
    }
}
