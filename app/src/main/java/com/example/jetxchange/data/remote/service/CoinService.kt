package com.example.jetxchange.data.remote.service

import com.example.jetxchange.data.model.coindetailresponse.CoinDetailDto
import com.example.jetxchange.data.model.coinresponse.CoinDto
import com.example.jetxchange.data.model.tagresponse.TagResponseItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    @GET("coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto


    @GET("tags")
    suspend fun getCoinById() : List<TagResponseItem>
}