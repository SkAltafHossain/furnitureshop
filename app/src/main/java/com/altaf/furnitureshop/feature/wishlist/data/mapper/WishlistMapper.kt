package com.altaf.furnitureshop.feature.wishlist.data.mapper

import com.altaf.furnitureshop.core.common.Constants
import com.altaf.furnitureshop.feature.product.data.mapper.ProductMapper
import com.altaf.furnitureshop.feature.wishlist.data.remote.dto.WishlistDto
import com.altaf.furnitureshop.feature.wishlist.data.remote.dto.WishlistItemDto
import com.altaf.furnitureshop.feature.wishlist.domain.model.Wishlist
import com.altaf.furnitureshop.feature.wishlist.domain.model.WishlistItem

object WishlistMapper {
    fun mapToDomain(dto: WishlistDto): Wishlist {
        return Wishlist(
            items = dto.data.map { mapItemToDomain(it) }
        )
    }

    fun mapItemToDomain(dto: WishlistItemDto): WishlistItem {
        return WishlistItem(
            id = dto.id,
            productId = dto.product_id,
            product = ProductMapper.mapToDomain(dto.product)
        )
    }
}
