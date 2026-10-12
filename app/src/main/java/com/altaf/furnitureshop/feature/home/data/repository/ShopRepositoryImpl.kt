package com.altaf.furnitureshop.feature.home.data.repository

import com.altaf.furnitureshop.core.error.ErrorMapper
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.home.data.mapper.ShopMapper
import com.altaf.furnitureshop.feature.home.data.remote.ShopApi
import com.altaf.furnitureshop.feature.home.domain.model.ShopInfo
import com.altaf.furnitureshop.feature.home.domain.model.ShopSettings
import com.altaf.furnitureshop.feature.home.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi
) : ShopRepository {
    
    override fun getShopSettings(): Flow<ResultState<ShopSettings>> = flow {
        emit(ResultState.Loading)
        try {
            val response = shopApi.getShopSettings()
            if (response.success && response.data != null) {
                val shopSettings = ShopMapper.mapToDomain(response.data)
                emit(ResultState.Success(shopSettings))
            } else {
                emit(ResultState.Error(response.message ?: "Operation failed"))
            }
        } catch (e: Exception) {
            val appError = ErrorMapper.mapToAppError(e)
            emit(ResultState.Error(appError.localizedMessage ?: appError.toString(), appError))
        }
    }
    
    override fun getShopInfo(): Flow<ResultState<ShopInfo>> = flow {
        emit(ResultState.Loading)
        try {
            val response = shopApi.getShopInfo()
            if (response.success && response.data != null) {
                val shopInfo = ShopMapper.mapToDomain(response.data)
                emit(ResultState.Success(shopInfo))
            } else {
                emit(ResultState.Error(response.message ?: "Operation failed"))
            }
        } catch (e: Exception) {
            val appError = ErrorMapper.mapToAppError(e)
            emit(ResultState.Error(appError.localizedMessage ?: appError.toString(), appError))
        }
    }
}