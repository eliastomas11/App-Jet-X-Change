package com.example.jetxchange.core.di.module

import com.example.jetxchange.core.di.module.qualifiers.DispatcherIO
import com.example.jetxchange.data.CoinRepositoryImpl
import com.example.jetxchange.data.local.CoinLocalSource
import com.example.jetxchange.data.networkhelper.NetworkHelper
import com.example.jetxchange.data.remote.CoinRemoteSource
import com.example.jetxchange.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinRepository(
        coinRemoteSource: CoinRemoteSource,
        coinLocalSource: CoinLocalSource,
        @DispatcherIO dispatcher: CoroutineDispatcher,
        networkHelper: NetworkHelper
    ): CoinRepository {
        return CoinRepositoryImpl(coinLocalSource, coinRemoteSource,dispatcher, networkHelper)
    }
}