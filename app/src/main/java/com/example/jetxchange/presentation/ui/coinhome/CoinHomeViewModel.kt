package com.example.jetxchange.presentation.ui.coinhome

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetxchange.data.model.Resource
import com.example.jetxchange.domain.usecase.CoinUseCase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinHomeViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {

    private val _uiState = mutableStateOf(CoinHomeUiState())
    val uiState: State<CoinHomeUiState> get() = _uiState

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            _uiState.value = CoinHomeUiState(isLoading = true)
            val coins = getCoinsUseCase()
            when (coins) {
                is Resource.Error -> _uiState.value =
                    CoinHomeUiState(isLoading = false, error = coins.message ?: "Unexpected error")

                is Resource.Success -> _uiState.value =
                    CoinHomeUiState(isLoading = false, coins = coins.data ?: emptyList())
            }
        }
    }

}