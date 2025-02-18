package com.example.krosovki.database

data class Cart(
    val id: Int,
    val name: String,
    val price: Double,
    val image_url: String,
    var amount: Int = 1
)
