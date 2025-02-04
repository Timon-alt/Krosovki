package com.example.krosovki.components

import com.example.krosovki.R

data class OnboardItems(val image: Int, val mainText: Int, val minorText: Int) {

}

val onboardItemsList = listOf(
    OnboardItems(R.drawable.noga_one, R.string.start_screen1, R.string.start_screen2),
    OnboardItems(R.drawable.noga_two, R.string.start_screen1, R.string.start_screen2),
    OnboardItems(R.drawable.noga_three, R.string.start_screen3, R.string.start_screen4),
)