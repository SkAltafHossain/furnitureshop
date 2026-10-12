package com.altaf.furnitureshop.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.altaf.furnitureshop.core.common.Constants
import com.altaf.furnitureshop.core.network.TokenProvider
import com.altaf.furnitureshop.core.network.TokenProviderImpl
import com.altaf.furnitureshop.core.preferences.ThemePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.PREF_NAME)

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }

    @Provides
    @Singleton
    fun provideTokenProvider(dataStore: DataStore<Preferences>): TokenProvider {
        return TokenProviderImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideThemePreferences(dataStore: DataStore<Preferences>): ThemePreferences {
        return ThemePreferences(dataStore)
    }
}