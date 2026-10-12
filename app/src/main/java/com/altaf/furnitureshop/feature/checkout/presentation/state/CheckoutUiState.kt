package com.altaf.furnitureshop.feature.checkout.presentation.state

import com.altaf.furnitureshop.feature.cart.domain.model.Cart
import com.altaf.furnitureshop.feature.checkout.domain.model.CheckoutResponse
import com.altaf.furnitureshop.feature.address.domain.model.Address

data class CheckoutUiState(
    val isLoading: Boolean = false,
    val cart: Cart? = null,
    val errorMessage: String? = null,
    val isProcessingCheckout: Boolean = false,
    val checkoutResponse: CheckoutResponse? = null,
    val selectedPaymentMethod: String = "cod",
    val isBuyNowMode: Boolean = false,
    val addresses: List<Address> = emptyList(),
    val selectedAddressId: Int? = null,
    val isLoadingAddresses: Boolean = false,
    val showConfirmationModal: Boolean = false,
    val shouldNavigateToOrders: Boolean = false
)
