package com.example.krosovki.controllers.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItem(val icon: ImageVector, val route: String) {
    object HomeScreen: BottomItem(Icons.Outlined.Home, "HomeScreen")
    object LikedScreen: BottomItem(Icons.Outlined.FavoriteBorder, "LikedScreen")
    object CatalogScreen: BottomItem(Icons.Outlined.Notifications, "CatalogScreen")
    object ProfileScreen: BottomItem(Icons.Outlined.Person, "ProfileScreen")
}