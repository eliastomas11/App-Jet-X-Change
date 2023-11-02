package com.example.jetxchange.presentation.ui.coindetail.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.jetxchange.R
import com.example.jetxchange.domain.model.CoinDetail

@Composable
fun DetailHeadLine(modifierHead: Modifier = Modifier, modifierLabel: Modifier, coin: CoinDetail) {
    Text(
        text = stringResource(
            R.string.coin_list_item_text,
            coin.rank,
            coin.name,
            coin.symbol
        ),
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifierHead
    )
    Text(
        text = if (coin.isActive) stringResource(R.string.coin_state_active) else stringResource(
            R.string.coin_state_inactvie
        ),
        color = if (coin.isActive) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.inversePrimary,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifierLabel
    )
}