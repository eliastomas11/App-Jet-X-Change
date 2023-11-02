package com.example.jetxchange.presentation.ui.coinhome.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetxchange.presentation.ui.coinhome.CoinHomeViewModel
import com.example.jetxchange.presentation.ui.navigation.routes.ScreenRoutes

@Composable
fun CoinHomeRoute(navController: NavController, viewModel: CoinHomeViewModel) {
    val uiState = viewModel.uiState.value
    CoinListScreen(
        state = uiState,
        onItemClick = { coin ->
            Log.d("COIN DETAIL", coin.id)
            navController.navigate(ScreenRoutes.DetailCoinScreen.route + "/${coin.id}")
        })
}