package com.example.krosovki.screens.navBar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.krosovki.controllers.bottomNavigation.BottomItem

@Composable
fun BottomNavBar(navController: NavController){
    val listOfItems = listOf(
        BottomItem.HomeScreen,
        BottomItem.PopularScreen,
        BottomItem.CatalogScreen,
        BottomItem.ProfileScreen
    )

    NavigationBar(

    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listOfItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(item.icon, "Icon")
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF48B2E7),
                    unselectedIconColor = Color.LightGray
                )
            )
        }
    }

}