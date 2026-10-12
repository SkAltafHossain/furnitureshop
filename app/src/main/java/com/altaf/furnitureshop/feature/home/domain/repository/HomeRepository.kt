package com.altaf.furnitureshop.feature.home.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.home.domain.model.HomeData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getHomeData(): Flow<ResultState<HomeData>>
}
