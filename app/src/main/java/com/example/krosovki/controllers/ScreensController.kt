package com.example.krosovki.controllers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.screens.DetailsScreen
import com.example.krosovki.screens.EnterWithoutPass
import com.example.krosovki.screens.LogInScreen
import com.example.krosovki.screens.MainScreen
import com.example.krosovki.screens.SearchScreen
import com.example.krosovki.screens.StartScreen
import com.example.krosovki.screens.navBar.LikedScreen
import com.example.krosovki.screens.navBar.PopularScreen

@Composable
fun ScrensController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "StartScreen"){
        composable("startScreen"){
            StartScreen() {
                navController.navigate("LoginScreen")
            }
        }
        composable("loginScreen"){
            LogInScreen() {
                navController.navigate("MainScreen")
            }
        }
        composable("enterWithoutPass"){
            EnterWithoutPass() {  }
        }
        composable("MainScreen"){
            MainScreen()
        }
        composable("SearchScreen") {
            SearchScreen()
        }
        composable("OtpScreen") {
            EnterWithoutPass {  }
        }
        composable("DetailsScreen") {
            DetailsScreen()
        }
        composable("SlideBar"){
            SlideMenuBar {  }
        }

    }
}