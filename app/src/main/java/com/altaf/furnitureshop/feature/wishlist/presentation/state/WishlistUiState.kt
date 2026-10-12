package com.altaf.furnitureshop.feature.wishlist.presentation.state

import com.altaf.furnitureshop.feature.wishlist.domain.model.Wishlist

data class WishlistUiState(
    val isLoading: Boolean = false,
    val wishlist: Wishlist? = null,
    val errorMessage: String? = null,
    val isAddingToWishlist: Boolean = false,
    val isRemovingFromWishlist: Boolean = false,
    val addToWishlistSuccess: Boolean = false,
    val addToWishlistMessage: String? = null,
    val removeFromWishlistMessage: String? = null
)
