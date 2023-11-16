package com.placek.maja.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel(){
    var selectedMode by mutableStateOf(DetailsViewMode.Actors)

    fun updateMode(it: DetailsViewMode) {
        selectedMode = it
    }
}

enum class DetailsViewMode {
    Actors, Scenes
}