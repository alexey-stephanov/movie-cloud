package com.alexstephanov.moviecloud.di

import androidx.lifecycle.ViewModel
import com.alexstephanov.moviecloud.repositories.movies.MoviesRepository
import com.alexstephanov.moviecloud.repositories.movies.MoviesRepositoryImpl
import com.alexstephanov.moviecloud.view.viewmodels.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface MoviesModule {

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    fun bindMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel

    @Singleton
    @Binds
    fun bindMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository
}