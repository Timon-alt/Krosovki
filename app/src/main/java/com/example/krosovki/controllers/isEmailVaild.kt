package com.example.krosovki.controllers

import android.util.Log
import android.util.Patterns

fun isEmailValid(email: String) : Boolean {
    val result = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    Log.d("EmaiValid", "$result")
    return result
}