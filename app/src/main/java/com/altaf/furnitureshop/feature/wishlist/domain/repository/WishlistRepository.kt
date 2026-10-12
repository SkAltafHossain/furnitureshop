package com.altaf.furnitureshop.feature.wishlist.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.wishlist.domain.model.Wishlist
import com.altaf.furnitureshop.feature.wishlist.domain.model.WishlistItem
import kotlinx.coroutines.flow.Flow

interface WishlistRepository {
    fun getWishlist(): Flow<ResultState<Wishlist>>
    fun addToWishlist(productId: Int): Flow<ResultState<WishlistItem>>
    fun removeFromWishlist(wishlistItemId: Int): Flow<ResultState<Unit>>
    fun checkInWishlist(productId: Int): Flow<ResultState<Boolean>>
}
