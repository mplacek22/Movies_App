package com.placek.maja.movies

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.placek.maja.movies.screens.Screen
import com.placek.maja.movies.screens.DetailsScreen
import com.placek.maja.movies.screens.MainScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailsScreen.route + "/{movie}",
            arguments = listOf(
                navArgument("movie"){
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )
        ) { backStackEntry ->
                DetailsScreen(navController = navController, movieTitle = backStackEntry.arguments?.getString("movie") ?: "")
        }
    }
}

