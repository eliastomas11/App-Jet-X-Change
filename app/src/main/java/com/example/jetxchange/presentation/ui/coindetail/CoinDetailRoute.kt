package com.example.jetxchange.presentation.ui.coindetail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetxchange.presentation.ui.coindetail.components.CoinDetailScreen


@Composable
fun CoinDetailRoute(viewModel: CoinDetailViewModel) {
    CoinDetailScreen(state = viewModel.uiState.value)
}

