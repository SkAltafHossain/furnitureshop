package com.altaf.furnitureshop.feature.address.di

import com.altaf.furnitureshop.feature.address.data.repository.AddressRepositoryImpl
import com.altaf.furnitureshop.feature.address.domain.repository.AddressRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AddressModule {

    @Binds
    @Singleton
    abstract fun bindAddressRepository(
        addressRepositoryImpl: AddressRepositoryImpl
    ): AddressRepository
}
