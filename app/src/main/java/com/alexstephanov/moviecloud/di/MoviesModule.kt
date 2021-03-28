package com.alexstephanov.moviecloud.di

import androidx.lifecycle.ViewModel
import com.alexstephanov.moviecloud.repositories.MoviesRepository
import com.alexstephanov.moviecloud.repositories.MoviesRepositoryImpl
import com.alexstephanov.moviecloud.view.viewmodels.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class MoviesModule {

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel

    @Singleton
    @Binds
    abstract fun bindMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository
}