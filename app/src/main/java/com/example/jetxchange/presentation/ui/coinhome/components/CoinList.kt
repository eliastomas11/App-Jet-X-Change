package com.example.jetxchange.presentation.ui.coinhome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetxchange.domain.model.Coin

@Composable
fun CoinList(modifier: Modifier = Modifier, coinList: List<Coin>, onItemClick: (Coin) -> Unit) {

    LazyColumn() {
        items(coinList) { coin ->
            CoinListItem(coin = coin, onItemClick = { onItemClick(coin) })
        }
    }

}