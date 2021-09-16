package com.projects.aldajo92.breakingbadapp.di

import android.app.Application
import com.projects.aldajo92.breakingbadapp.BaseApplication
import com.projects.aldajo92.breakingbadapp.di.repository.RepositoryModule
import com.projects.aldajo92.breakingbadapp.di.ui.ActivityBuilderModule
import com.projects.aldajo92.breakingbadapp.di.ui.FragmentBuilderModule
import com.projects.aldajo92.breakingbadapp.di.viewmodel.ViewModelModule
import com.projects.aldajo92.breakingbadapp.framework.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}