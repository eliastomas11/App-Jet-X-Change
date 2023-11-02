package com.example.jetxchange.presentation.ui.coindetail

import com.example.jetxchange.domain.model.CoinDetail

data class CoinDetailUiState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
