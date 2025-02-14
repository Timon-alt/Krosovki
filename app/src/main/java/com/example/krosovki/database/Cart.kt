package com.example.krosovki.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val id: Int,
    val user_uid: String,
    val name: String,
    val price: Float,
    val image_url: String
)
