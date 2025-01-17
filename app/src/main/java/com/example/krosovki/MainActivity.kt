package com.example.krosovki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.krosovki.screens.StartScreen
import com.example.krosovki.ui.theme.KrosovkiTheme

// https://www.figma.com/design/YFIQ0o0c2VozfcVD5PQAxN/Matule-with-Style-guide-ORIG-(Main)?node-id=8103-748&t=25NIK4P5pw25X0jl-0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            KrosovkiTheme { StartScreen() }
        }
    }
}