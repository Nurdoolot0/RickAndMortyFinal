package com.example.rickandmortyfinal.ui.screens.locations.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyfinal.data.repository.Repository
import com.example.rickandmortyfinal.data.models.LocationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationDetailViewModel(private val repository: Repository) : ViewModel() {

    private val _location = MutableStateFlow<LocationResponse.Location?>(null)
    val location: StateFlow<LocationResponse.Location?> get() = _location

    fun fetchLocationById(id: Int) {
        viewModelScope.launch {
            val response = repository.getLocationById(id)
            if (response.isSuccessful) {
                _location.value = response.body()
            }
        }
    }
}