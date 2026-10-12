package com.altaf.furnitureshop.feature.home.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.home.domain.model.ShopInfo
import com.altaf.furnitureshop.feature.home.domain.model.ShopSettings
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    fun getShopSettings(): Flow<ResultState<ShopSettings>>
    fun getShopInfo(): Flow<ResultState<ShopInfo>>
}