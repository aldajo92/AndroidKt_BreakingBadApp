package com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.network.search.CharactersResponse
import com.projects.aldajo92.breakingbadapp.repository.country.CharactersRepository
import com.projects.aldajo92.breakingbadapp.presentation.events.DashBoardEvents
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashBoardViewModel @Inject constructor(
    private val characterRepository: CharactersRepository<BBCharacter>,
) : ViewModel() {

    private val _characterItems = mutableListOf<BBCharacter>()
    val characterItems: List<BBCharacter> get() = _characterItems

    private val _responseLiveData = MutableLiveData<DashBoardEvents<*>>()
    val responseLiveData: LiveData<DashBoardEvents<*>> get() = _responseLiveData

    fun getCharacters() {
        viewModelScope.launch {
            try {
                val listResult = characterRepository.getItems()
                Timber.i("result size: ${listResult?.size}")
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
