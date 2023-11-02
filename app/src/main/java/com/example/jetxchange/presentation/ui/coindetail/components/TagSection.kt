package com.example.jetxchange.presentation.ui.coindetail.components

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun TagSection(modifier: Modifier = Modifier, tags: List<String>) {
    Text(
        text = "Tags",
        style = MaterialTheme.typography.headlineSmall
    )
    Spacer(modifier = Modifier.height(15.dp))
    FlowRow(
        modifier = modifier,
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 10.dp
    ) {
        tags.forEach { tag ->
            CoinTag(tag = tag)
        }

    }
}