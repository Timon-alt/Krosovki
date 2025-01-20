package com.example.krosovki.controllers.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItem(val icon: ImageVector, val route: String) {
    object HomeScreen: BottomItem(Icons.Filled.Home, "HomeScreen")
    object PopularScreen: BottomItem(Icons.Filled.Favorite, "PopularScreen")
    object CatalogScreen: BottomItem(Icons.Filled.Notifications, "CatalogScreen")
    object ProfileScreen: BottomItem(Icons.Filled.Person, "ProfileScreen")
}