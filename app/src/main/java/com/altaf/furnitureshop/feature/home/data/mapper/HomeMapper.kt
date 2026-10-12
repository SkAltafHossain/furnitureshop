package com.altaf.furnitureshop.feature.home.data.mapper

import com.altaf.furnitureshop.feature.category.data.mapper.CategoryMapper
import com.altaf.furnitureshop.feature.home.data.remote.dto.BannerDto
import com.altaf.furnitureshop.feature.home.data.remote.dto.HomeApiResponseDto
import com.altaf.furnitureshop.feature.home.domain.model.Banner
import com.altaf.furnitureshop.feature.home.domain.model.HomeData
import com.altaf.furnitureshop.feature.product.data.mapper.ProductMapper

object HomeMapper {
    fun mapToDomain(dto: HomeApiResponseDto): HomeData {
        return HomeData(
            banners = dto.banners.map { mapBanner(it) },
            products = ProductMapper.mapToDomainList(dto.products),
            categories = CategoryMapper.mapToDomainList(dto.categories),
            latestProducts = ProductMapper.mapToDomainList(dto.latestProducts),
            featuredProducts = ProductMapper.mapToDomainList(dto.featuredProducts)
        )
    }

    private fun mapBanner(dto: BannerDto): Banner {
        return Banner(
            id = dto.id,
            title = dto.title ?: "",
            description = dto.description,
            image = dto.image ?: "",
            status = dto.status ?: ""
        )
    }
}
