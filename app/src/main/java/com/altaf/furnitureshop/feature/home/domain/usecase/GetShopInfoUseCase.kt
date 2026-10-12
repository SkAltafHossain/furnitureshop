package com.altaf.furnitureshop.feature.home.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.home.domain.model.ShopInfo
import com.altaf.furnitureshop.feature.home.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShopInfoUseCase @Inject constructor(
    private val repository: ShopRepository
) {
    operator fun invoke(): Flow<ResultState<ShopInfo>> {
        return repository.getShopInfo()
    }
}