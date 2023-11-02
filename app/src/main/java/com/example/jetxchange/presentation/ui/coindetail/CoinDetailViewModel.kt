package com.example.jetxchange.presentation.ui.coindetail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jetxchange.data.model.Resource
import com.example.jetxchange.core.Constants.PARAM_COIN_ID
import com.example.jetxchange.domain.usecase.CoinUseCase.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    init {
        getCoinDetail(savedStateHandle.get<String>(PARAM_COIN_ID) ?: "")
    }

    private val _uiState = mutableStateOf(CoinDetailUiState(isLoading = true))
    val uiState: State<CoinDetailUiState> get() = _uiState

    private fun getCoinDetail(coinId: String) {
        viewModelScope.launch {
            val coinDetail = getCoinDetailUseCase(coinId)
            when (coinDetail) {
                is Resource.Error -> _uiState.value = CoinDetailUiState(
                    isLoading = false,
                    error = coinDetail.message ?: "Unexpected error"
                )

                is Resource.Success -> {
                    _uiState.value = CoinDetailUiState(isLoading = false, coin = coinDetail.data)
                }
            }
        }
    }

    fun onInit(coinId: String) {
        getCoinDetail(coinId)
    }

}