package com.alexstephanov.moviecloud.di

import androidx.lifecycle.ViewModel
import com.alexstephanov.moviecloud.repositories.moviedetails.MovieDetailsRepository
import com.alexstephanov.moviecloud.repositories.moviedetails.MovieDetailsRepositoryImpl
import com.alexstephanov.moviecloud.view.viewmodels.MovieDetailsViewModel
import com.alexstephanov.moviecloud.view.viewmodels.factories.MovieDetailsViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface MovieDetailsModule {

    @Singleton
    @Binds
    fun bindMovieDetailsRepository(movieDetailsRepositoryImpl: MovieDetailsRepositoryImpl): MovieDetailsRepository

    companion object {
        @Singleton
        @Provides
        fun provideMovieDetailsViewModelFactory(movieDetailsRepository: MovieDetailsRepository) =
            MovieDetailsViewModelFactory(movieDetailsRepository)
    }
}