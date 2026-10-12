package com.altaf.furnitureshop.feature.address.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.address.domain.model.Address
import com.altaf.furnitureshop.feature.address.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAddressesUseCase @Inject constructor(
    private val repository: AddressRepository
) {
    operator fun invoke(): Flow<ResultState<List<Address>>> {
        return repository.getAddresses()
    }
}
