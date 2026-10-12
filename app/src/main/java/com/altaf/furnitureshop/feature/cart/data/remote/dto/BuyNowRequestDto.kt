package com.altaf.furnitureshop.feature.cart.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuyNowRequestDto(
    @SerialName("product_id")
    val productId: Int,

    @SerialName("quantity")
    val quantity: Int
)
