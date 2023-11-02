package com.example.jetxchange.presentation.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetxchange.core.Constants
import com.example.jetxchange.core.Constants.PARAM_COIN_ID
import com.example.jetxchange.presentation.ui.coindetail.CoinDetailRoute
import com.example.jetxchange.presentation.ui.coindetail.CoinDetailViewModel
import com.example.jetxchange.presentation.ui.coinhome.CoinHomeViewModel
import com.example.jetxchange.presentation.ui.coinhome.components.CoinHomeRoute
import com.example.jetxchange.presentation.ui.navigation.routes.ScreenRoutes.*

@Composable
fun NavigationCore(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeCoinScreen.route) {
        composable(route = HomeCoinScreen.route) {
            val homeViewModel: CoinHomeViewModel = hiltViewModel()
            CoinHomeRoute(navController = navController, homeViewModel)
        }
        composable(route = DetailCoinScreen.route + "/{${PARAM_COIN_ID}}",
            arguments = listOf(navArgument(name = PARAM_COIN_ID) {
                type = NavType.StringType
            })
        ) {
            val detailViewModel: CoinDetailViewModel = hiltViewModel()
            CoinDetailRoute(viewModel = detailViewModel)
        }
    }
}