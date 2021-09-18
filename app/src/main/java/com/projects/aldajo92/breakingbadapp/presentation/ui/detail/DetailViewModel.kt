package com.projects.aldajo92.breakingbadapp.presentation.ui.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.repository.favorites.FavoritesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository<BBCharacter>
): ViewModel() {

    val characterField = ObservableField<BBCharacter>()
    val isFavoriteField = ObservableField(false)

    fun initInfo(character: BBCharacter) {
        this.characterField.set(character)
    }

    fun toggleFavorites() {
        characterField.get()?.let {
            viewModelScope.launch {
//                favoritesRepository.saveToFavorites(it)
            }
        }
    }

}