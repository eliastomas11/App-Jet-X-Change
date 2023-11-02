package com.example.jetxchange.data.mapper

import com.example.jetxchange.data.local.model.CoinDetailEntity
import com.example.jetxchange.data.local.model.CoinEntity
import com.example.jetxchange.data.model.coindetailresponse.CoinDetailDto
import com.example.jetxchange.data.model.coinresponse.CoinDto
import com.example.jetxchange.domain.model.Coin
import com.example.jetxchange.domain.model.CoinDetail

fun CoinDto.toCoin() = Coin(
    id = id,
    isActive = isActive,
    name = name,
    rank = rank,
    symbol = symbol,
)

fun CoinDto.toCoinEntity() = CoinEntity(
    id = id,
    isActive = isActive,
    name = name,
    rank = rank,
    symbol = symbol,
)

fun CoinDetailDto.toCoinDetail() = CoinDetail(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    tags = tags.map { it.name },
    team = team,
)

fun CoinDetailDto.toCoinDetailEntity() = CoinDetailEntity(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    //tags = tags.map { it.name },
    //team = team,
)