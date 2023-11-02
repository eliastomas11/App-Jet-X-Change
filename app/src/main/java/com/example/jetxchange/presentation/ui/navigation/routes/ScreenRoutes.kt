package com.example.jetxchange.presentation.ui.navigation.routes

sealed class ScreenRoutes(val route:String){

    data object HomeCoinScreen: ScreenRoutes("coin_list_screen")

    data object DetailCoinScreen: ScreenRoutes("coin_detail_screen")

}
