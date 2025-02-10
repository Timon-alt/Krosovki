package com.example.krosovki.controllers

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FilterTextViewModel: ViewModel() {
    private val items = listOf(
        "New Shoes",
        "Nike Top Shoes",
        "Nike Air Force",
        "Shoes",
        "Snakers Nike Shoes",
        "Regular Shoes"
    )

    private val _filteredItems = MutableStateFlow(items)
    var filteredItems: StateFlow<List<String>> = _filteredItems

    fun filterText(input: String) {
        // Этот фильтр вернёт полный список айтемов, если инпут как пустая строка
        _filteredItems.value = items.filter {it.contains(input, ignoreCase = true)}
    }
}