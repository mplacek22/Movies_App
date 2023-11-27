package com.placek.maja.movies.screens

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object DetailsScreen: Screen("detail_screen")
    object VideoPlayerScreen: Screen("video_player_screen")

    fun withArgs( vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
