package com.projects.aldajo92.breakingbadapp.presentation.ui.detail

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.repository.CharactersRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class DetailViewModelTest {

    @Mock
    lateinit var characterRepository: CharactersRepository<BBCharacter>

    lateinit var viewModel : DetailViewModel

    @Before
    fun setUp() {
        viewModel = DetailViewModel(characterRepository)
    }

    @Test
    fun saveImage() {

        viewModel.saveImage()
    }
}