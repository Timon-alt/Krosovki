package com.example.krosovki.database

import android.util.Log
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from

class UsersGateWay {
    private val supabase = createSupabaseClient(
        supabaseUrl = "https://clkpilwlzctjicjnyrnj.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNsa3BpbHdsemN0amljam55cm5qIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzg1ODk5NzIsImV4cCI6MjA1NDE2NTk3Mn0.CQwfYEqybYlwtYwHx3v7Tg4Zy4oZ7XkOm--7UzGyEwQ"
    ) {
        install(Postgrest)
        install(Auth) {
            host = ""
            scheme = "scheme://host"
        }
    }

    suspend fun signUp(email: String, password: String) : Boolean {
        return try {
            supabase.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            Log.d("signIn", "Unexpected error: ${e.message}")
            false
        }
    }

    suspend fun signIn(email: String, password: String) : Boolean {
        return try {
            supabase.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            Log.d("signIn", "Unexpected error: ${e.message}")
            false
        }
    }

    // Сделать восстановления пароля юзеру.

    suspend fun resetPassword(email: String) {}


}