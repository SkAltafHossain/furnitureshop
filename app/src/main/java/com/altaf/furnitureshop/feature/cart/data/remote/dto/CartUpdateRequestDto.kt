package com.altaf.furnitureshop.feature.cart.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartUpdateRequestDto(
    @SerialName("quantity")
    val quantity: Int
)
