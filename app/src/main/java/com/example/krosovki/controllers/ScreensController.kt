package com.example.krosovki.controllers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.screens.LogInScreen
import com.example.krosovki.screens.StartScreen

@Composable
fun ScrensController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "startScreen"){
        composable("startScreen"){
            StartScreen() {
                navController.navigate("LoginScreen")
            }
        }
        composable("loginScreen"){
            LogInScreen() {
                // Переход на мэйн экран
            }
        }
    }


}