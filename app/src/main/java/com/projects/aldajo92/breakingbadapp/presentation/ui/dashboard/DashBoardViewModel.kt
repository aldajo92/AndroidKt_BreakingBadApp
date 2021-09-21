package com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.aldajo92.breakingbadapp.PAGINATION_AMOUNT
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.repository.CharactersRepository
import com.projects.aldajo92.breakingbadapp.presentation.events.DashBoardEvents
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashBoardViewModel @Inject constructor(
    private val characterRepository: CharactersRepository<BBCharacter>
) : ViewModel() {

    init {
        firstFetchCharacters()
    }

    private val _characterItems = mutableListOf<BBCharacter>()
    val characterItems: List<BBCharacter> get() = _characterItems

    private val _responseLiveData = MutableLiveData<DashBoardEvents<*>>()
    val responseLiveData: LiveData<DashBoardEvents<*>> get() = _responseLiveData

    private fun firstFetchCharacters() {
        viewModelScope.launch {
            try {
                val listResult = characterRepository.performFirstSearch()
                _responseLiveData.value = DashBoardEvents.ProductsSuccess(listResult)

                _characterItems.clear()
                _characterItems.addAll(listResult ?: emptyList())
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun getProductsByPagination(totalItemCount: Int) {
        viewModelScope.launch {
            try {
                val listResult =
                    characterRepository.fetchItemsPagination(PAGINATION_AMOUNT, totalItemCount)
                _responseLiveData.value = DashBoardEvents.ProductsPaginationSuccess(listResult)
                _characterItems.addAll(listResult ?: emptyList())
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun toggleFavorites(character: BBCharacter, state: Boolean) {
        viewModelScope.launch {
            characterRepository.toggleFavoriteCharacterState(character, state)
        }
    }
}

