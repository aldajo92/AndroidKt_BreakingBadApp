package com.projects.aldajo92.breakingbadapp.di

import android.app.Application
import com.projects.aldajo92.breakingbadapp.BaseApplication
import com.projects.aldajo92.breakingbadapp.repository.di.RepositoryModule
import com.projects.aldajo92.breakingbadapp.di.ui.ActivityBuilderModule
import com.projects.aldajo92.breakingbadapp.di.ui.FragmentBuilderModule
import com.projects.aldajo92.breakingbadapp.di.viewmodel.ViewModelModule
import com.projects.aldajo92.breakingbadapp.framework.db.di.DBModule
import com.projects.aldajo92.breakingbadapp.framework.network.di.NetworkModule
import com.projects.aldajo92.breakingbadapp.framework.storage.di.StorageModule
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
        RepositoryModule::class,
        DBModule::class,
        StorageModule::class
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