package com.example.krosovki.database

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class CartRepository {
    private val supabase = createSupabaseClient(
        supabaseUrl = "https://clkpilwlzctjicjnyrnj.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNsa3BpbHdsemN0amljam55cm5qIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzg1ODk5NzIsImV4cCI6MjA1NDE2NTk3Mn0.CQwfYEqybYlwtYwHx3v7Tg4Zy4oZ7XkOm--7UzGyEwQ"
    ) {
        install(Postgrest)
    }

    suspend fun getCart(user_uid: String) {

    }
}