package com.example.jetxchange.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetxchange.data.local.dao.CoinDao
import com.example.jetxchange.data.local.dao.CoinDetailDao
import com.example.jetxchange.data.local.model.CoinDetailEntity
import com.example.jetxchange.data.local.model.CoinEntity

@Database(entities = [CoinEntity::class,CoinDetailEntity::class], version = 1)
abstract class CoinDb: RoomDatabase() {

    abstract fun coinDao(): CoinDao

    abstract fun coinDetailDao(): CoinDetailDao
}