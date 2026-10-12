package com.altaf.furnitureshop.feature.cart.presentation.state

import com.altaf.furnitureshop.feature.cart.domain.model.Cart
import com.altaf.furnitureshop.feature.cart.domain.model.CartItem

data class CartUiState(
    val isLoading: Boolean = false,
    val cart: Cart? = null,
    val errorMessage: String? = null,
    val isAddingToCart: Boolean = false,
    val isUpdatingItem: Boolean = false,
    val isDeletingItem: Boolean = false,
    val isClearingCart: Boolean = false,
    val successMessage: String? = null
)
