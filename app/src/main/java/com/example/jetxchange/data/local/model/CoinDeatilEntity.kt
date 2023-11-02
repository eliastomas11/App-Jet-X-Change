package com.example.jetxchange.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetxchange.data.model.coindetailresponse.TeamMember

@Entity(tableName = "coin_detail")
data class CoinDetailEntity(
   @PrimaryKey val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    //val tags: List<String>,
    //val team: List<TeamMember>,
)