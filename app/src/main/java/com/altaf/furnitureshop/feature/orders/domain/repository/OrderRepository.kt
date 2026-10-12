package com.altaf.furnitureshop.feature.orders.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.orders.domain.model.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getOrders(): Flow<ResultState<List<Order>>>
    fun getOrderDetails(orderId: Int): Flow<ResultState<Order>>
    fun confirmDelivered(orderId: Int): Flow<ResultState<Unit>>
    fun downloadBill(orderId: Int): Flow<ResultState<okhttp3.ResponseBody>>
}
