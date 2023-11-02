package com.example.jetxchange.domain.usecase

import com.example.jetxchange.data.model.Resource
import com.example.jetxchange.domain.model.Coin
import com.example.jetxchange.domain.model.CoinDetail

sealed interface CoinUseCase{

    fun interface GetCoinsUseCase: suspend () -> Resource<List<Coin>>

    fun interface GetCoinDetailUseCase: suspend (String) -> Resource<CoinDetail>

}