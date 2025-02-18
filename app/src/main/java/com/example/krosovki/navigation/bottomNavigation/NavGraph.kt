package com.example.krosovki.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.controllers.SneakersViewModel
import com.example.krosovki.screens.navBar.CatalogScreen
import com.example.krosovki.screens.navBar.HomeScreen
import com.example.krosovki.screens.navBar.LikedScreen
import com.example.krosovki.screens.navBar.PopularScreen
import com.example.krosovki.screens.navBar.ProfileScreen

@Composable
fun NavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = "HomeScreen"){
        composable("HomeScreen") {
            HomeScreen() {
                navHostController.navigate("PopularScreen")
            }
        }
        composable("CatalogScreen") {
            CatalogScreen()
        }
        composable("LikedScreen") {
            LikedScreen(navHostController)
        }
        composable("ProfileScreen") {
            ProfileScreen()
        }
        composable("PopularScreen") {
            PopularScreen(navHostController) {

            }
        }

    }
}