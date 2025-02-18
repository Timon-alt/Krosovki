package com.example.krosovki.controllers

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.krosovki.database.FavItems

class FavItemsViewModel: ViewModel() {
    private val _favItemsList = mutableStateListOf<FavItems>()
    val favItems: List<FavItems> get() = _favItemsList

    fun addItem(favItems: FavItems) {
        _favItemsList.add(favItems)
    }

    fun deleteItem(favItems: FavItems) {
        _favItemsList.remove(favItems)
    }
}