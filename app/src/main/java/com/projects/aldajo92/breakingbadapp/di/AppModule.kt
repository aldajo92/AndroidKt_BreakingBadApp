package com.projects.aldajo92.breakingbadapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun bindContext(application: Application): Context {
        return application.applicationContext
    }
}
