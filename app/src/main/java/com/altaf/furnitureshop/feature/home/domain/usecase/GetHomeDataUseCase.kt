package com.altaf.furnitureshop.feature.home.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.home.domain.model.HomeData
import com.altaf.furnitureshop.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    operator fun invoke(): Flow<ResultState<HomeData>> {
        return repository.getHomeData()
    }
}
