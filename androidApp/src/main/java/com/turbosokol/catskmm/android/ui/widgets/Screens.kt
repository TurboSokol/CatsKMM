package com.turbosokol.catskmm.android.ui.widgets

sealed class Screens(val route: String) {
    object MainScreen: Screens(route = "main_screen")
    object DetailScreen: Screens(route = "{arg}/detail_screen"){
        fun createRoute(arg: String?) = "$arg/detail_screen"
    }
}
