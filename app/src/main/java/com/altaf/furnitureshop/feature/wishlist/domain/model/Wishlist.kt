package com.altaf.furnitureshop.feature.wishlist.domain.model

import com.altaf.furnitureshop.feature.product.domain.model.Product

data class Wishlist(
    val items: List<WishlistItem>
)

data class WishlistItem(
    val id: Int,
    val productId: Int,
    val product: Product
)
