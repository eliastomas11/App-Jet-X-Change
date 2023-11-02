package com.example.jetxchange.presentation.ui.coindetail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetxchange.presentation.ui.coindetail.CoinDetailUiState
import com.example.jetxchange.presentation.ui.coinhome.components.ErrorScreen
import com.example.jetxchange.presentation.ui.coinhome.components.LoadingScreen

@Composable
fun CoinDetailScreen(state: CoinDetailUiState) {

    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->
            DetailList(modifier = Modifier, coin =  coin)
        }
        if (state.isLoading) {
            LoadingScreen(modifier = Modifier.align(Alignment.Center))
        }
        if (state.error.isNotBlank()) {
            ErrorScreen(
                modifier = Modifier
                    .matchParentSize()
                    .align(Alignment.Center), errorText = state.error
            )
        }

    }
}



