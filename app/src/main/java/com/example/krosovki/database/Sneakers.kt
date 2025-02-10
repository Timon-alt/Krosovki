package com.example.krosovki.database

import kotlinx.serialization.Serializable

@Serializable
data class Sneakers(
    val id: Int?,
    val name: String,
    val price: Float,
    val image: String
)
