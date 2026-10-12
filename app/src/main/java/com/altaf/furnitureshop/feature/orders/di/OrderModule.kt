package com.altaf.furnitureshop.feature.orders.di

import com.altaf.furnitureshop.feature.orders.data.repository.OrderRepositoryImpl
import com.altaf.furnitureshop.feature.orders.domain.repository.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class OrderModule {

    @Binds
    @Singleton
    abstract fun bindOrderRepository(
        orderRepositoryImpl: OrderRepositoryImpl
    ): OrderRepository
}
