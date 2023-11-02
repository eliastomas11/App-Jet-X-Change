package com.example.jetxchange.presentation.ui.coindetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetxchange.domain.model.CoinDetail

@Composable
fun DetailList(modifier: Modifier = Modifier, coin: CoinDetail) {
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(20.dp)) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DetailHeadLine(
                    modifierHead = Modifier.weight(8f),
                    modifierLabel = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(2f),
                    coin = coin
                )
            }

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = coin.description,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(15.dp))
                TagSection(modifier = Modifier.fillMaxWidth(), tags = coin.tags)
                Spacer(modifier = Modifier.height(15.dp))
            }
        items(coin.team) { teamMember ->
            TeamListItem(
                teamMember = teamMember, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Divider()
        }
    }
}




