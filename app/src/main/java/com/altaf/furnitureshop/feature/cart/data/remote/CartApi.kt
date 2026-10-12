package com.altaf.furnitureshop.feature.cart.data.remote

import com.altaf.furnitureshop.core.network.ApiResponse
import com.altaf.furnitureshop.feature.cart.data.remote.dto.AddToCartResponseDto
import com.altaf.furnitureshop.feature.cart.data.remote.dto.BuyNowRequestDto
import com.altaf.furnitureshop.feature.cart.data.remote.dto.BuyNowResponseDto
import com.altaf.furnitureshop.feature.cart.data.remote.dto.CartDto
import com.altaf.furnitureshop.feature.cart.data.remote.dto.CartItemDto
import com.altaf.furnitureshop.feature.cart.data.remote.dto.CartRequestDto
import com.altaf.furnitureshop.feature.cart.data.remote.dto.CartUpdateRequestDto
import com.altaf.furnitureshop.feature.checkout.data.remote.dto.CheckoutRequestDto
import com.altaf.furnitureshop.feature.checkout.data.remote.dto.CheckoutResponseDto
import com.altaf.furnitureshop.feature.orders.data.remote.dto.OrderDto
import com.altaf.furnitureshop.feature.orders.data.remote.dto.PaginatedOrdersResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CartApi {
    @POST("cart")
    suspend fun addToCart(@Body request: CartRequestDto): ApiResponse<AddToCartResponseDto>
    
    @GET("cart")
    suspend fun getCart(): ApiResponse<CartDto>
    
    @PUT("cart/{id}")
    suspend fun updateCartItem(
        @Path("id") cartItemId: Int,
        @Body request: CartUpdateRequestDto
    ): ApiResponse<Unit>
    
    @DELETE("cart/{id}")
    suspend fun deleteCartItem(@Path("id") cartItemId: Int): ApiResponse<Unit>
    
    @DELETE("cart")
    suspend fun clearCart(): ApiResponse<Unit>

    @POST("cart/buy-now")
    suspend fun buyNow(@Body request: BuyNowRequestDto): ApiResponse<BuyNowResponseDto>

    @POST("orders")
    suspend fun checkout(@Body request: CheckoutRequestDto): ApiResponse<CheckoutResponseDto>

    @GET("orders")
    suspend fun getOrders(): ApiResponse<PaginatedOrdersResponse>

    @GET("orders/{orderId}")
    suspend fun getOrderDetails(@Path("orderId") orderId: Int): ApiResponse<OrderDto>

    @PUT("orders/{id}/confirm-delivery")
    suspend fun confirmDelivered(@Path("id") orderId: Int): ApiResponse<Unit>

    @GET("orders/{id}/download")
    suspend fun downloadBill(@Path("id") orderId: Int): retrofit2.Response<okhttp3.ResponseBody>
}
