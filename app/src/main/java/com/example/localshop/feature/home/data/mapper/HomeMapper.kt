package com.example.localshop.feature.home.data.mapper

import com.example.localshop.feature.category.data.mapper.CategoryMapper
import com.example.localshop.feature.home.data.remote.dto.BannerDto
import com.example.localshop.feature.home.data.remote.dto.HomeApiResponseDto
import com.example.localshop.feature.home.domain.model.Banner
import com.example.localshop.feature.home.domain.model.HomeData
import com.example.localshop.feature.product.data.mapper.ProductMapper

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
