package com.altaf.furnitureshop.feature.home.data.repository

import com.altaf.furnitureshop.core.error.ErrorMapper
import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.home.data.mapper.HomeMapper
import com.altaf.furnitureshop.feature.home.data.remote.ShopApi
import com.altaf.furnitureshop.feature.home.domain.model.HomeData
import com.altaf.furnitureshop.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi
) : HomeRepository {
    
    override fun getHomeData(): Flow<ResultState<HomeData>> = flow {
        emit(ResultState.Loading)
        try {
            val response = shopApi.getHomeData()
            if (response.success && response.data != null) {
                val homeData = HomeMapper.mapToDomain(response.data)
                emit(ResultState.Success(homeData))
            } else {
                emit(ResultState.Error(response.message ?: "Failed to load home data"))
            }
        } catch (e: Exception) {
            val appError = ErrorMapper.mapToAppError(e)
            emit(ResultState.Error(appError.localizedMessage ?: appError.toString(), appError))
        }
    }
}
