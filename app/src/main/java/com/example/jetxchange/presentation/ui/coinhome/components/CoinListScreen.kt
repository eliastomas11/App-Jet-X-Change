package com.example.jetxchange.presentation.ui.coinhome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetxchange.domain.model.Coin
import com.example.jetxchange.presentation.ui.coinhome.CoinHomeUiState

@Composable
fun CoinListScreen(
    state: CoinHomeUiState,
    onItemClick: (Coin) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (state.isLoading) {
            LoadingScreen(modifier = Modifier.align(Alignment.Center))
        }
        if (state.error.isNotBlank()) {
            ErrorScreen(modifier = Modifier
                .matchParentSize()
                .align(Alignment.Center), errorText = state.error)
        }
        if (state.coins.isNotEmpty()) {
            CoinList(modifier = Modifier
                .matchParentSize(),
                state.coins,
                onItemClick = { onItemClick(it) })
        }
    }


}





