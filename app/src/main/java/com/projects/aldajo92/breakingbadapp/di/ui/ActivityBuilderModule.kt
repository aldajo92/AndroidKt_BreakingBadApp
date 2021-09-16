package com.projects.aldajo92.breakingbadapp.di.ui

import com.projects.aldajo92.breakingbadapp.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}