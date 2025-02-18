package com.example.krosovki.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.components.MyAnimationsTest
import com.example.krosovki.components.SlideMenuBar
import com.example.krosovki.screens.DetailsScreen
import com.example.krosovki.screens.EnterWithoutPass
import com.example.krosovki.screens.LoginScreen
import com.example.krosovki.screens.MainScreen
import com.example.krosovki.screens.SearchScreen
import com.example.krosovki.screens.StartScreen

@Composable
fun ScrensController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainScreen"){
        composable("startScreen"){
            StartScreen() {
                navController.navigate("LoginScreen")
            }
        }
        composable("loginScreen"){
            LoginScreen {
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
        // Тест анимаций
        composable("AnimationsTest") {
            MyAnimationsTest()
        }

    }
}