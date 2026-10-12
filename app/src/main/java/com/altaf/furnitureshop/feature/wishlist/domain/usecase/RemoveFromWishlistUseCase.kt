package com.altaf.furnitureshop.feature.wishlist.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.wishlist.domain.repository.WishlistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoveFromWishlistUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository
) {
    operator fun invoke(wishlistItemId: Int): Flow<ResultState<Unit>> {
        return wishlistRepository.removeFromWishlist(wishlistItemId)
    }
}
