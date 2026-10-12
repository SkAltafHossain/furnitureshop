package com.altaf.furnitureshop.feature.home.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.home.domain.model.ShopSettings
import com.altaf.furnitureshop.feature.home.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShopSettingsUseCase @Inject constructor(
    private val repository: ShopRepository
) {
    operator fun invoke(): Flow<ResultState<ShopSettings>> {
        return repository.getShopSettings()
    }
}