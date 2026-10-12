package com.altaf.furnitureshop.feature.wishlist.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.wishlist.domain.model.Wishlist
import com.altaf.furnitureshop.feature.wishlist.domain.repository.WishlistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWishlistUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository
) {
    operator fun invoke(): Flow<ResultState<Wishlist>> {
        return wishlistRepository.getWishlist()
    }
}
