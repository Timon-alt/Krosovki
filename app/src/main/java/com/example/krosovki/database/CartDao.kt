package com.example.krosovki.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun getAll(): LiveData<List<Cart>>

    @Insert
    fun insertAll(vararg cart: Cart)

    @Delete
    fun delete(cart: Cart)
}