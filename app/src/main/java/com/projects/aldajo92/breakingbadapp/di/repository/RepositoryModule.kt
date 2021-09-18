package com.projects.aldajo92.breakingbadapp.di.repository

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.repository.characters.CharacterRepositoryImpl
import com.projects.aldajo92.breakingbadapp.repository.characters.CharactersRepository
import com.projects.aldajo92.breakingbadapp.repository.favorites.FavoritesRepository
import com.projects.aldajo92.breakingbadapp.repository.favorites.FavoritesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideCharacterRepository(breakingBadApi: BreakingBadApi): CharactersRepository<BBCharacter> {
        return CharacterRepositoryImpl(breakingBadApi)
    }

    @Provides
    @Singleton
    internal fun provideFavoriteRepository(): FavoritesRepository<BBCharacter> {
        return FavoritesRepositoryImpl()
    }
}
