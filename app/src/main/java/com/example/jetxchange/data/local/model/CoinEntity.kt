package com.example.jetxchange.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coin")
data class CoinEntity(
    @PrimaryKey val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)