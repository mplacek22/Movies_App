package com.placek.maja.movies.screens

enum class MovieScreens {
    MainScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route :String?)  : MovieScreens
                = when (route?.substringBefore("/")) {
            MainScreen.name -> MainScreen
            DetailsScreen.name -> DetailsScreen
            null -> MainScreen
            else -> throw java.lang.IllegalArgumentException("Route $route is not recognized")
        }
    }
}