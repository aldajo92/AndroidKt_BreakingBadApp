package com.projects.aldajo92.breakingbadapp.di.repository

import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.framework.BreakingBadApi
import com.projects.aldajo92.breakingbadapp.repository.characters.BBCharacterRepositoryImpl
import com.projects.aldajo92.breakingbadapp.repository.characters.CharactersRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideCharacterRepository(breakingBadApi: BreakingBadApi): CharactersRepository<BBCharacter> {
        return BBCharacterRepositoryImpl(breakingBadApi)
    }
}
