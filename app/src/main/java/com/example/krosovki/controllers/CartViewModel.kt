package com.example.krosovki.controllers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.krosovki.database.Cart

class CartViewModel(private val cartRepository: CartRepository) : ViewModel() {

    /**
     * Сохраняет текущее состояние пользовательского интерфейса элемента
     */
    var cartUiState by mutableStateOf(CartUiState())
        private set

    /**
     * Обновляет [CartUiState] значением, указанным в аргументе.
     */
    fun updateUiState(cartDetails: CartDetails) {
        cartUiState =
            CartUiState(cartDetails = cartDetails)
    }


    suspend fun saveItemInCart() {
       // cartRepository.inertItemToCart()
    }
}

/**
 * Представляет состояние пользовательского интерфейса для корзины.
 */
data class CartUiState(
    val cartDetails: CartDetails = CartDetails()
)

data class CartDetails(
    val id: Int = 0,
    val name: String = "",
    val price: Float = 0.0f,
    val image_url: String = ""
)

/**
 *  Экстенш функция, которая конвертирует [CartDetails] в [Cart]
 */

fun CartDetails.toCart(): Cart = Cart(
    id = id,
    name = name,
    price = price,
    image_url = image_url
)

/**
 * Экстенш функция, которая конвертирует [Cart] в [CartUiState]
 */
fun Cart.toCartUiState(): CartUiState = CartUiState(
    cartDetails = this.toCartDetails()
)

/**
 * Экстенш функция, которая конвертирует [Cart] в [CartDetails]
 */
fun Cart.toCartDetails(): CartDetails = CartDetails(
    id = id,
    name = name,
    price = price,
    image_url = image_url
)