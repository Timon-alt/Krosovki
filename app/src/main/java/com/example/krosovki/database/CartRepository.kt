package com.example.krosovki.database

import androidx.lifecycle.LiveData
import com.example.krosovki.screens.navBar.counter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartRepository(private val cartDao: CartDao) {
    private val corountineScope = CoroutineScope(Dispatchers.Main)

    val cartList: LiveData<List<Cart>> = cartDao.getAll()

    fun addToCart(cart: Cart) {
        corountineScope.launch {
            cartDao.insertAll()
        }
    }

    fun deleteCartItem(cart: Cart) {
        corountineScope.launch {
            cartDao.delete(cart)
        }
    }
}