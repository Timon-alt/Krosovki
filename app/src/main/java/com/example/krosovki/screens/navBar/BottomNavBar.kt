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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.krosovki.controllers.bottomNavigation.BottomItem

@Composable
fun BottomNavBar(navController: NavController){
    val listOfItems = listOf(
        BottomItem.HomeScreen,
        BottomItem.LikedScreen,
        BottomItem.CatalogScreen,
        BottomItem.ProfileScreen
    )

    NavigationBar(


    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        var selectedItemIndex by rememberSaveable { mutableStateOf(0) }



        listOfItems.forEachIndexed { index, item ->
            var iconColor = if(selectedItemIndex == index) Color(0xFF48B2E7) else Color.Gray

            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                    selectedItemIndex = index

                },
                icon = {
                    Icon(item.icon, "Icon",
                        tint = iconColor)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF48B2E7),
                    unselectedIconColor = Color.LightGray
                )
            )
        }
    }

}