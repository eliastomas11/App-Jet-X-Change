package com.example.jetxchange.data.remote

import com.example.jetxchange.data.model.coindetailresponse.CoinDetailDto
import com.example.jetxchange.data.model.coinresponse.CoinDto
import com.example.jetxchange.data.remote.service.CoinService
import javax.inject.Inject

class CoinRemoteSource @Inject constructor(private val coinService: CoinService) {

    suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinService.getCoinById(coinId)
    }

    suspend fun getCoins(): List<CoinDto> {
        return coinService.getCoins()
    }
}