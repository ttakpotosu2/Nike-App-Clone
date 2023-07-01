package com.example.nikeappclone

sealed class Screen (val route: String) {
    object HomeScreen : Screen("home_screen")
    object LoginScreen : Screen("login_screen")
    object WelcomeScreen : Screen("welcome_screen")
    object LocationScreen : Screen("location_screen")
    object SignedInScreen : Screen("signed_in_screen")
    object LanguageSelectionScreen : Screen("language_selection_screen")
    object LoginDetailsScreen : Screen("login_details_screen")
    object DetailedInfoScreen : Screen("detailed_info_screen")
    object MainScreen : Screen("main_screen")

}
