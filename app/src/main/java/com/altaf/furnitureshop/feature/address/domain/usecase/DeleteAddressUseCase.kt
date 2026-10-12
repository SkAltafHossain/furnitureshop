package com.altaf.furnitureshop.feature.address.domain.usecase

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.address.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteAddressUseCase @Inject constructor(
    private val repository: AddressRepository
) {
    operator fun invoke(addressId: Int): Flow<ResultState<Unit>> {
        return repository.deleteAddress(addressId)
    }
}
