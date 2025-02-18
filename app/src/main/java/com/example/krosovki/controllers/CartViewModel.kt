package com.example.krosovki.controllers

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.krosovki.database.Cart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel() : ViewModel() {

    private val _cartList = mutableStateListOf<Cart>()
    val cartList: List<Cart> get() = _cartList

    fun addItem(cart: Cart) {
        val existingProduct = _cartList.find { it.id == cart.id }
        if (existingProduct != null) {
            existingProduct.amount++
        } else {
            _cartList.add(cart)
        }

    }

    fun deleteItem(cart: Cart) {
        _cartList.remove(cart)
    }

    fun getTotalPrice(): Double {
        return _cartList.fold(0.0) {total, product ->
            total + (product.price * product.amount)
        }
    }

    fun getItemsAmount(): Int {
        return _cartList.size
    }
}
