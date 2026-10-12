package com.altaf.furnitureshop.feature.cart.data.mapper

import com.altaf.furnitureshop.core.common.Constants
import com.altaf.furnitureshop.feature.cart.data.remote.dto.BuyNowResponseDto
import com.altaf.furnitureshop.feature.cart.domain.model.BuyNowData
import com.altaf.furnitureshop.feature.cart.domain.model.Cart
import com.altaf.furnitureshop.feature.cart.domain.model.CartItem
import com.altaf.furnitureshop.feature.cart.domain.model.Category
import com.altaf.furnitureshop.feature.cart.domain.model.Product

object BuyNowMapper {
    fun toDomain(dto: BuyNowResponseDto): BuyNowData {
        return BuyNowData(
            product = toProductDomain(dto.product),
            quantity = dto.quantity,
            price = dto.price.toDoubleOrNull() ?: 0.0,
            subtotal = dto.subtotal,
            shipping = dto.shipping,
            total = dto.total,
            isBuyNow = dto.isBuyNow
        )
    }

    fun toCart(buyNowData: BuyNowData): Cart {
        val cartItem = CartItem(
            id = 0, // Temporary ID for Buy Now
            productId = buyNowData.product.id,
            productName = buyNowData.product.name,
            productImage = buyNowData.product.imageUrl,
            price = buyNowData.product.price,
            discountPrice = buyNowData.product.discountPrice,
            quantity = buyNowData.quantity,
            subtotal = buyNowData.subtotal
        )

        return Cart(
            items = listOf(cartItem),
            subtotal = buyNowData.price,
            total = buyNowData.total,
            cartCount = 1
        )
    }

    private fun toProductDomain(dto: com.altaf.furnitureshop.feature.cart.data.remote.dto.BuyNowProductDto): Product {
        val imagePath = dto.image
        val fullImageUrl = if (!imagePath.isNullOrBlank()) {
            if (imagePath.startsWith("http://") || imagePath.startsWith("https://")) {
                imagePath
            } else {
                "${Constants.IMAGE_BASE_URL}${imagePath}"
            }
        } else {
            ""
        }

        return Product(
            id = dto.id,
            categoryId = dto.categoryId,
            name = dto.name,
            slug = dto.slug,
            description = dto.description,
            price = dto.price.toDoubleOrNull() ?: 0.0,
            discountPrice = dto.discountPrice?.toDoubleOrNull(),
            stock = dto.stock,
            imageUrl = fullImageUrl,
            status = dto.status,
            featured = dto.featured,
            createdAt = dto.createdAt,
            updatedAt = dto.updatedAt,
            deletedAt = dto.deletedAt,
            category = toCategoryDomain(dto.category)
        )
    }

    private fun toCategoryDomain(dto: com.altaf.furnitureshop.feature.cart.data.remote.dto.CategoryDto): Category {
        val imagePath = dto.image
        val fullImageUrl = if (!imagePath.isNullOrBlank()) {
            if (imagePath.startsWith("http://") || imagePath.startsWith("https://")) {
                imagePath
            } else {
                "${Constants.IMAGE_BASE_URL}${imagePath}"
            }
        } else {
            ""
        }

        return Category(
            id = dto.id,
            name = dto.name,
            slug = dto.slug,
            image = fullImageUrl,
            status = dto.status,
            createdAt = dto.createdAt,
            updatedAt = dto.updatedAt,
            deletedAt = dto.deletedAt
        )
    }
}
