package com.example.krosovki.database

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val id: Int?,
    val email: String,
    val name: String,
    val password: String
)