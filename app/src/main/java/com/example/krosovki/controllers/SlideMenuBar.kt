package com.example.krosovki.controllers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
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
import com.example.krosovki.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlideMenuBar(
    content: @Composable (PaddingValues) -> Unit
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                        .background(Color(0xFF48B2E7))
                ) {
                    Spacer(Modifier.height(12.dp))
                    Image(
                        painter = painterResource(R.drawable.yaica),
                        contentDescription = "Ava",
                        modifier = Modifier
                            .background(shape = CircleShape, color = Color.Gray)
                            .size(96.dp))

                    Text("Человек яйца", modifier = Modifier.padding(16.dp))


                    Text("Section 1", modifier = Modifier.padding(16.dp))
                    NavigationDrawerItem(
                        label = { Text("Профиль") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        label = { Text("Корзина") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        label = { Text("Избранное") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        label = { Text("Заказы") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        label = { Text("Уведомления") },
                        selected = false,
                        onClick = {}
                    )
                    NavigationDrawerItem(
                        label = { Text("Настройки") },
                        selected = false,
                        onClick = {}
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    Text("Section 2", modifier = Modifier.padding(16.dp))
                    NavigationDrawerItem(
                        label = { Text("Выйти") },
                        selected = false,
                        onClick = {}
                    )

                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer Example") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSlideMenuBar() {
    SlideMenuBar({})
}