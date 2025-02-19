package com.example.krosovki.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.DeliveryDining
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.krosovki.R
import com.example.krosovki.navigation.bottomNavigation.NavGraph
import com.example.krosovki.screens.navBar.BottomNavBar
import com.example.krosovki.ui.theme.KrosovkiTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlideMenuBar(
    content: @Composable (PaddingValues) -> Unit
) {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxSize(),
                drawerContainerColor = Color(0xFF48B2E7)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())

                ) {
                    Spacer(Modifier.height(12.dp))
                    Image(
                        painter = painterResource(R.drawable.yaica),
                        contentDescription = "Ava",
                        modifier = Modifier
                            .background(shape = CircleShape, color = Color.Gray)
                            .size(96.dp))

                    Text("Человек яйца", modifier = Modifier.padding(16.dp))

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Outlined.Person, "Person") },
                        label = { Text(text = "Профиль") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        icon = { Icon(Icons.Outlined.ShoppingBag, "Cart") },
                        label = { Text(text = "Корзина") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        icon = { Icon(Icons.Outlined.FavoriteBorder, "add") },
                        label = { Text(text = "Избранное") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        icon = { Icon(painter = painterResource(R.drawable.orders), "Deliver") },
                        label = { Text(text = "Заказы") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        icon = { Icon(Icons.Outlined.Notifications, "Notifications") },
                        label = { Text(text = "Уведомления") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        icon = { Icon(Icons.Outlined.Settings, "Settings") },
                        label = { Text(text = "Настройки") },
                        selected = false,
                        onClick = {}
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    NavigationDrawerItem(
                        icon = { Icon(painter = painterResource(R.drawable.logout), "Logout") },
                        label = {  Text(text = "Выйти") },
                        selected = false,
                        onClick = {}
                    )
                }
            }
        }
    ) {
        KrosovkiTheme {
            Scaffold(
                bottomBar = {
                    BottomNavBar(navController = navController)
                }

            ) { innerPadding ->
                content(innerPadding)
                NavGraph(navHostController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSlideMenuBar() {
    SlideMenuBar({})
}