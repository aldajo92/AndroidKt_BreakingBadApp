package com.projects.aldajo92.breakingbadapp.framework.db.di

import android.content.Context
import androidx.room.Room
import com.projects.aldajo92.breakingbadapp.framework.db.BBFavoritesDatabase
import com.projects.aldajo92.breakingbadapp.framework.db.dao.FavoriteCharactersDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Provides
    @Singleton
    internal fun provideMeliFavoritesDatabase(context: Context): BBFavoritesDatabase {
        return Room.databaseBuilder(context, BBFavoritesDatabase::class.java, "favorite_products")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideFavoriteDao(database: BBFavoritesDatabase): FavoriteCharactersDao {
        return database.favoriteProductDao()
    }

}
