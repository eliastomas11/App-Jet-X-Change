package com.example.jetxchange.data

import com.example.jetxchange.data.model.Resource
import com.example.jetxchange.data.local.CoinLocalSource
import com.example.jetxchange.data.mapper.toCoin
import com.example.jetxchange.data.mapper.toCoinDetail
import com.example.jetxchange.data.networkhelper.NetworkHelper
import com.example.jetxchange.data.remote.CoinRemoteSource
import com.example.jetxchange.domain.model.Coin
import com.example.jetxchange.domain.model.CoinDetail
import com.example.jetxchange.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val localSource: CoinLocalSource,
    private val remoteSource: CoinRemoteSource,
    private val dispatcher: CoroutineDispatcher,
    private val networkHelper: NetworkHelper,
) : CoinRepository {

    override suspend fun getCoins(): Resource<List<Coin>> {
        return withContext(dispatcher) {
            try {
                Resource.Success(remoteSource.getCoins().map { it.toCoin() })
            } catch (e: Exception) {
                Resource.Error(message = e.message ?: "Unknown error")
            }
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        return withContext(dispatcher) {
            try {
                Resource.Success(remoteSource.getCoinById(coinId).toCoinDetail())
            } catch (e: Exception) {
                Resource.Error(message = e.message ?: "Unknown error")
            }
        }
    }
}