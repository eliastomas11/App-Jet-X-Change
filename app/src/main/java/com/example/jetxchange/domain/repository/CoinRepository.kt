package com.example.jetxchange.domain.repository

import com.example.jetxchange.data.model.Resource
import com.example.jetxchange.domain.model.Coin
import com.example.jetxchange.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): Resource<List<Coin>>

    suspend fun getCoinById(coinId: String): Resource<CoinDetail>

}