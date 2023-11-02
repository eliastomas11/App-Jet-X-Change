package com.example.jetxchange.core.di.module

import com.example.jetxchange.core.Constants.BASE_URL
import com.example.jetxchange.data.networkhelper.NetworkHelper
import com.example.jetxchange.data.networkhelper.NetworkHelperImpl
import com.example.jetxchange.data.remote.CoinRemoteSource
import com.example.jetxchange.data.remote.service.CoinService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkHelper(): NetworkHelper{
        return NetworkHelperImpl()
    }

    @Provides
    @Singleton
    fun providesServiceClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun providesApiService(client: Retrofit): CoinService {
        return client.create(CoinService::class.java)
    }
    @Provides
    @Singleton
    fun providesRemoteSource(service: CoinService): CoinRemoteSource {
        return CoinRemoteSource(service)
    }
}