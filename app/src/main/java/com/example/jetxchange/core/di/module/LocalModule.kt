package com.example.jetxchange.core.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetxchange.core.Constants.DB_NAME
import com.example.jetxchange.data.local.CoinLocalSource
import com.example.jetxchange.data.local.dao.CoinDao
import com.example.jetxchange.data.local.dao.CoinDetailDao
import com.example.jetxchange.data.local.db.CoinDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {


    @Provides
    @Singleton
    fun providesCoinDb(@ApplicationContext context: Context): CoinDb {
        return Room.databaseBuilder(context, CoinDb::class.java, DB_NAME).build()
    }

    @Provides
    @Singleton
    fun providesCoinDao(coinDb: CoinDb): CoinDao {
        return coinDb.coinDao()
    }

    @Provides
    @Singleton
    fun providesCoinDetailDao(coinDb: CoinDb): CoinDetailDao {
        return coinDb.coinDetailDao()
    }

    @Provides
    @Singleton
    fun providesCoinLocalSource(coinDao: CoinDao, coinDetailDao: CoinDetailDao): CoinLocalSource {
        return CoinLocalSource(coinDao, coinDetailDao)
    }
}