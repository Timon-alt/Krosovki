package com.example.krosovki.controllers

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.krosovki.database.Sneakers
import com.example.krosovki.database.SneakersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SneakersViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val sneakersRepository = SneakersRepository()

    // приватный StateFlow для хранения списка
    private val _sneakersList = MutableStateFlow<List<Sneakers>>(emptyList())

    // публичный StateFlow для наблюдения за списком
    val snekaersList: StateFlow<List<Sneakers>> = _sneakersList

    fun loadSneakers() {
        viewModelScope.launch {
            _sneakersList.value = sneakersRepository.getSneakers()
        }
    }
}