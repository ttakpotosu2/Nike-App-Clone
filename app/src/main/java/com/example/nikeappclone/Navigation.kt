package com.example.nikeappclone

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.LoginScreen.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.LoginDetailsScreen.route
        ){
            LoginDetailsScreen(navController = navController)
        }
        composable(
            route = Screen.SignedInScreen.route
        ){
            SignedInScreen(navController = navController)
        }
        composable(
            route = Screen.LanguageSelectionScreen.route
        ){
            LanguageSelectionScreen(navController = navController)
        }
        composable(
            route = Screen.WelcomeScreen.route
        ){
            WelcomeScreen(navController = navController)
        }
        composable(
            route = Screen.LocationScreen.route
        ){
            LocationScreen(navController = navController)
        }
        composable(
            route = Screen.DetailedInfoScreen.route
        ){
            DetailedInfoScreen(navController = navController)
        }
        composable(
            route = Screen.MainScreen.route
        ){
            MainScreen(navController = navController)
        }
    }
}
