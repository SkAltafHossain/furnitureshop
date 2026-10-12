package com.altaf.furnitureshop.core.di

import com.altaf.furnitureshop.feature.auth.data.repository.AuthRepositoryImpl
import com.altaf.furnitureshop.feature.auth.domain.repository.AuthRepository
import com.altaf.furnitureshop.feature.cart.data.repository.CartRepositoryImpl
import com.altaf.furnitureshop.feature.cart.domain.repository.CartRepository
import com.altaf.furnitureshop.feature.category.data.repository.CategoryRepositoryImpl
import com.altaf.furnitureshop.feature.category.domain.repository.CategoryRepository
import com.altaf.furnitureshop.feature.checkout.data.repository.CheckoutRepositoryImpl
import com.altaf.furnitureshop.feature.checkout.domain.repository.CheckoutRepository
import com.altaf.furnitureshop.feature.home.data.repository.HomeRepositoryImpl
import com.altaf.furnitureshop.feature.home.data.repository.ShopRepositoryImpl
import com.altaf.furnitureshop.feature.home.domain.repository.HomeRepository
import com.altaf.furnitureshop.feature.home.domain.repository.ShopRepository
import com.altaf.furnitureshop.feature.product.data.repository.ProductRepositoryImpl
import com.altaf.furnitureshop.feature.product.domain.repository.ProductRepository
import com.altaf.furnitureshop.feature.wishlist.data.repository.WishlistRepositoryImpl
import com.altaf.furnitureshop.feature.wishlist.domain.repository.WishlistRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Binds
    @Singleton
    abstract fun bindShopRepository(
        shopRepositoryImpl: ShopRepositoryImpl
    ): ShopRepository
    
    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
    
    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
    
    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository
    
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
    
    @Binds
    @Singleton
    abstract fun bindCartRepository(
        cartRepositoryImpl: CartRepositoryImpl
    ): CartRepository
    
    @Binds
    @Singleton
    abstract fun bindCheckoutRepository(
        checkoutRepositoryImpl: CheckoutRepositoryImpl
    ): CheckoutRepository

    @Binds
    @Singleton
    abstract fun bindWishlistRepository(
        wishlistRepositoryImpl: WishlistRepositoryImpl
    ): WishlistRepository
}