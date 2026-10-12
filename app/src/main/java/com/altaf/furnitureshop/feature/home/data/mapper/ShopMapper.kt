package com.altaf.furnitureshop.feature.home.data.mapper

import com.altaf.furnitureshop.feature.home.data.remote.dto.ShopInfoDto
import com.altaf.furnitureshop.feature.home.data.remote.dto.ShopSettingsDto
import com.altaf.furnitureshop.feature.home.data.remote.dto.SocialLinksDto
import com.altaf.furnitureshop.feature.home.domain.model.ShopInfo
import com.altaf.furnitureshop.feature.home.domain.model.ShopSettings
import com.altaf.furnitureshop.feature.home.domain.model.SocialLinks

object ShopMapper {
    fun mapToDomain(dto: ShopSettingsDto): ShopSettings {
        return ShopSettings(
            id = dto.id ?: 0,
            shopName = dto.shopName ?: "",
            shopDescription = dto.shopDescription,
            shopEmail = dto.shopEmail,
            shopPhone = dto.shopPhone,
            shopAddress = dto.shopAddress,
            currency = dto.currency,
            logo = dto.logo,
            enableRegistration = dto.enableRegistration,
            enableGuestCheckout = dto.enableGuestCheckout,
            deliveryCharge = dto.deliveryCharge,
            freeDeliveryThreshold = dto.freeDeliveryThreshold,
            taxRate = dto.taxRate,
            socialLinks = dto.socialLinks?.let { mapSocialLinks(it) }
        )
    }
    
    fun mapToDomain(dto: ShopInfoDto): ShopInfo {
        return ShopInfo(
            id = dto.id ?: 0,
            name = dto.shopName ?: "",
            description = dto.shopDescription,
            email = dto.shopEmail,
            phone = dto.shopPhone,
            address = dto.shopAddress,
            logo = dto.logo,
            coverImage = dto.coverImage,
            socialLinks = dto.socialLinks?.let { mapSocialLinks(it) }
        )
    }
    
    private fun mapSocialLinks(dto: SocialLinksDto): SocialLinks {
        return SocialLinks(
            facebook = dto.facebook,
            twitter = dto.twitter,
            instagram = dto.instagram,
            linkedin = dto.linkedin
        )
    }
}