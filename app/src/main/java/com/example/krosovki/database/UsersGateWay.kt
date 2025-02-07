package com.example.krosovki.database

import android.util.Log
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import java.util.UUID
import kotlin.uuid.Uuid

class UsersGateWay {
    private val supabase = createSupabaseClient(
        supabaseUrl = "https://clkpilwlzctjicjnyrnj.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNsa3BpbHdsemN0amljam55cm5qIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzg1ODk5NzIsImV4cCI6MjA1NDE2NTk3Mn0.CQwfYEqybYlwtYwHx3v7Tg4Zy4oZ7XkOm--7UzGyEwQ"
    ) {
        install(Postgrest)
        install(Auth)
    }

    suspend fun signUp(email: String, password: String) : Boolean {
        return try {
            supabase.auth.retrieveUserForCurrentSession(updateSession = true)
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

    suspend fun getUserId() : String {
        val user = supabase.auth.retrieveUserForCurrentSession(updateSession = true)
        return user.id
    }

    suspend fun createProfile(id: UUID, firstname: String?,
                              lastname: String?, phone: String?) : Boolean {
        return try {
            supabase.from("profiles").insert(
                mapOf(
                    "id" to id,
                    "first_name" to firstname,
                    "last_name" to lastname,
                    "phone" to phone
                )
            )
            true
        } catch (e: Exception) {
            Log.d("signUp", "Unexpected error: ${e.message}")
            false
        }
    }

    // Сделать восстановления пароля юзеру.

    suspend fun resetPassword(email: String) {}


}