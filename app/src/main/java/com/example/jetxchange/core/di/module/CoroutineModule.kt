package com.example.jetxchange.core.di.module

import com.example.jetxchange.core.di.module.qualifiers.DispatcherDefault
import com.example.jetxchange.core.di.module.qualifiers.DispatcherIO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {

    @DispatcherIO
    @Provides
    fun providesDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @DispatcherDefault
    fun providesDispatcherDefault() : CoroutineDispatcher = Dispatchers.Default
}