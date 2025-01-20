package com.example.krosovki.controllers.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.krosovki.screens.navBar.CatalogScreen
import com.example.krosovki.screens.navBar.HomeScreen
import com.example.krosovki.screens.navBar.PopularScreen
import com.example.krosovki.screens.navBar.ProfileScreen

@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "HomeScreen"){
        composable("HomeScreen") {
            HomeScreen()
        }
        composable("CatalogScreen") {
            CatalogScreen()
        }
        composable("PopularScreen") {
            PopularScreen()
        }
        composable("ProfileScreen") {
            ProfileScreen()
        }
    }
}