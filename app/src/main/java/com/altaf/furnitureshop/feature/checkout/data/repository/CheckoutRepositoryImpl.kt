package com.altaf.furnitureshop.feature.checkout.data.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.cart.data.remote.CartApi
import com.altaf.furnitureshop.feature.checkout.data.mapper.CheckoutMapper
import com.altaf.furnitureshop.feature.checkout.domain.model.CheckoutRequest
import com.altaf.furnitureshop.feature.checkout.domain.model.CheckoutResponse
import com.altaf.furnitureshop.feature.checkout.domain.repository.CheckoutRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import javax.inject.Inject

class CheckoutRepositoryImpl @Inject constructor(
    private val cartApi: CartApi
) : CheckoutRepository {

    private fun <T> extractErrorMessageFromResponse(response: com.altaf.furnitureshop.core.network.ApiResponse<T>): String {
        // If message is generic like "Validation failed", try to get specific errors
        if (response.message == "Validation failed" || response.message == "Validation error") {
            if (response.errors != null) {
                for ((field, errorElement) in response.errors) {
                    when (errorElement) {
                        is JsonArray -> {
                            // Handle array of error messages - take first one
                            if (errorElement.isNotEmpty()) {
                                val firstError = errorElement[0]
                                if (firstError is JsonPrimitive) {
                                    return firstError.content
                                }
                            }
                        }
                        else -> {
                            // Handle single error message as string
                            if (errorElement is JsonPrimitive) {
                                return errorElement.content
                            }
                        }
                    }
                }
            }
        }
        return response.message ?: "Operation failed"
    }

    override fun processCheckout(request: CheckoutRequest): Flow<ResultState<CheckoutResponse>> = flow {
        emit(ResultState.Loading)
        try {
            val requestDto = CheckoutMapper.toDto(request)
            android.util.Log.d("Checkout", "Request DTO: isBuyNow=${requestDto.isBuyNow}, addressId=${requestDto.addressId}, paymentMethod=${requestDto.paymentMethod}, items=${requestDto.items.size}")
            val response = cartApi.checkout(requestDto)
            if (response.success && response.data != null) {
                val checkoutResponse = CheckoutMapper.toDomain(response.data)
                emit(ResultState.Success(checkoutResponse))
            } else {
                val errorMessage = extractErrorMessageFromResponse(response)
                emit(ResultState.Error(errorMessage))
            }
        } catch (e: Exception) {
            val errorMessage = e.message ?: "Failed to process checkout"
            emit(ResultState.Error(errorMessage))
        }
    }
}
