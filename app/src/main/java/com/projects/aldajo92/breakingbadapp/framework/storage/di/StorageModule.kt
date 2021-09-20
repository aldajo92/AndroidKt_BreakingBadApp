package com.projects.aldajo92.breakingbadapp.framework.storage.di

import com.projects.aldajo92.breakingbadapp.framework.storage.ImageStorage
import com.projects.aldajo92.breakingbadapp.framework.storage.ImageStorageImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    internal fun provideImageStorage(): ImageStorage {
        return ImageStorageImpl()
    }

}