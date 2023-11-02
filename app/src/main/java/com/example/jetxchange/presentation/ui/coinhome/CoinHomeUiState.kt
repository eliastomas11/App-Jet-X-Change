package com.example.jetxchange.presentation.ui.coinhome

import com.example.jetxchange.domain.model.Coin

data class CoinHomeUiState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
