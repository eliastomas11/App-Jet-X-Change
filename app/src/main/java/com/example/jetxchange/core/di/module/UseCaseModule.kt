package com.example.jetxchange.core.di.module

import com.example.jetxchange.domain.repository.CoinRepository
import com.example.jetxchange.domain.usecase.CoinUseCase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(
        coinRepository: CoinRepository,
    ): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepository::getCoins)
    }

    @Provides
    @Singleton
    fun provideGetCoinDetailUseCase(
        coinRepository: CoinRepository,
    ): GetCoinDetailUseCase {
        return GetCoinDetailUseCase(coinRepository::getCoinById)
    }
}