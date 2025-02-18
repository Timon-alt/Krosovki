package com.example.krosovki.screens

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.components.SlideMenuBar
import com.example.krosovki.navigation.bottomNavigation.NavGraph
import com.example.krosovki.screens.navBar.BottomNavBar
import com.example.krosovki.ui.theme.KrosovkiTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    SlideMenuBar {  }
}