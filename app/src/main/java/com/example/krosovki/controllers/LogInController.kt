package com.example.krosovki.controllers

import android.util.Log
import com.example.krosovki.database.UsersGateWay
import io.github.jan.supabase.auth.status.SessionSource
import kotlinx.coroutines.runBlocking

class LogInController {

    private val user = UsersGateWay()

    fun signIn(email: String,  password: String) : Boolean {

        var result = false

        if (isEmailValid(email)) {
            runBlocking {
                result = user.signIn(email, password)
                Log.d("SignInController", "$result")
            }
        }
        return result
    }

    fun signUp(email: String,  password: String) : Boolean {

        var result = true

        if (isEmailValid(email)) {
            runBlocking {
                result = user.signUp(email, password)
            }
        }
        return result
    }
}