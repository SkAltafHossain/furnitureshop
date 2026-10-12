package com.altaf.furnitureshop.feature.category.data.mapper

import com.altaf.furnitureshop.feature.category.data.remote.dto.CategoryWithProductsDto
import com.altaf.furnitureshop.feature.category.domain.model.CategoryWithProducts
import com.altaf.furnitureshop.feature.product.data.mapper.ProductMapper

object CategoryWithProductsMapper {
    fun mapToDomain(dto: CategoryWithProductsDto): CategoryWithProducts {
        return CategoryWithProducts(
            category = CategoryMapper.mapToDomain(dto.category),
            products = dto.products.map { ProductMapper.mapToDomain(it) }
        )
    }
}