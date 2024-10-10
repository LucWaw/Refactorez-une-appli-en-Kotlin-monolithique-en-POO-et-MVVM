package com.openclassrooms.notes.di

import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * AppModule is responsible for providing application-level dependencies
 * for the entire app. This module is installed in the SingletonComponent
 * ensuring that the provided instances are retained throughout the app's lifecycle.
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    /**
     * Provides a singleton instance of the RestaurantApi. In this example,
     * a fake implementation of the API is being used, which can be helpful
     * during testing or mock scenarios.
     *
     * @return A singleton instance of the RestaurantFakeApi.
     */
    @Provides
    @Singleton
    fun provideRestaurantApi() : NotesApiService  {
        return LocalNotesApiService()
    }
}