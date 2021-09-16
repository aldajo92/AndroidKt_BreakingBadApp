package com.projects.aldajo92.breakingbadapp.di.ui

import com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard.DashboardFragment
import com.projects.aldajo92.breakingbadapp.presentation.ui.detail.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindDashBoardFragment(): DashboardFragment

    @ContributesAndroidInjector
    abstract fun bindDetailFragment(): DetailFragment
}
