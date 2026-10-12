package com.altaf.furnitureshop.feature.cart.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.cart.domain.model.BuyNowData
import com.altaf.furnitureshop.feature.cart.domain.model.Cart
import com.altaf.furnitureshop.feature.cart.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun addToCart(productId: Int, quantity: Int): Flow<ResultState<CartItem>>
    fun getCart(): Flow<ResultState<Cart>>
    fun updateCartItem(cartItemId: Int, quantity: Int): Flow<ResultState<Unit>>
    fun deleteCartItem(cartItemId: Int): Flow<ResultState<Unit>>
    fun clearCart(): Flow<ResultState<Unit>>
    fun buyNow(productId: Int, quantity: Int): Flow<ResultState<BuyNowData>>
}
