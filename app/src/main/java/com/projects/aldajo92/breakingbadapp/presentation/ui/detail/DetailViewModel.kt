package com.projects.aldajo92.breakingbadapp.presentation.ui.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.repository.CharactersRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailViewModel @Inject constructor(
    private val characterRepository: CharactersRepository<BBCharacter>
) : ViewModel() {

    val characterField = ObservableField<BBCharacter>()
    val isFavoriteField = ObservableField(false)

    fun initInfo(character: BBCharacter) {
        this.characterField.set(character)
    }

    fun toggleFavorites() {
        val state = !(isFavoriteField.get() ?: false)

        if (state) {
            characterField.get()?.isFavorite = true
            characterField.get()?.let {
                viewModelScope.launch {
                    characterRepository.saveFavoriteItem(it)
                }
            }
        } else {

        }

        isFavoriteField.set(state)
    }

}