package com.example.jetxchange.data.local

import com.example.jetxchange.data.local.dao.CoinDao
import com.example.jetxchange.data.local.dao.CoinDetailDao
import javax.inject.Inject

class CoinLocalSource @Inject constructor(
    private val coinDao: CoinDao,
    private val coinDetailDao: CoinDetailDao,
) {
}