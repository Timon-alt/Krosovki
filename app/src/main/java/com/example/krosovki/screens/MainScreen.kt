package com.example.krosovki.screens

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.controllers.bottomNavigation.NavGraph
import com.example.krosovki.screens.navBar.BottomNavBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) {
        NavGraph(navHostController = navController)
    }
}