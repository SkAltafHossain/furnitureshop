package com.altaf.furnitureshop.feature.address.domain.repository

import com.altaf.furnitureshop.core.result.ResultState
import com.altaf.furnitureshop.feature.address.domain.model.Address
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    fun getAddresses(): Flow<ResultState<List<Address>>>
    fun addAddress(address: Address): Flow<ResultState<Address>>
    fun updateAddress(addressId: Int, address: Address): Flow<ResultState<Address>>
    fun deleteAddress(addressId: Int): Flow<ResultState<Unit>>
    fun setDefaultAddress(addressId: Int): Flow<ResultState<Unit>>
}
