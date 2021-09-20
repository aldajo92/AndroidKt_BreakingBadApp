package com.projects.aldajo92.breakingbadapp.repository.di

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.repository.CharacterRepositoryImpl
import com.projects.aldajo92.breakingbadapp.repository.CharactersRepository
import com.projects.aldajo92.breakingbadapp.repository.FavoritesRepository
import com.projects.aldajo92.breakingbadapp.repository.FavoritesRepositoryImpl
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
