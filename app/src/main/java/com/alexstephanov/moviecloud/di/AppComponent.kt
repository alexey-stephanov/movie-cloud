package com.alexstephanov.moviecloud.di

import android.content.Context
import com.alexstephanov.moviecloud.view.ui.MainActivity
import com.alexstephanov.moviecloud.view.ui.fragments.MovieDetailsFragment
import com.alexstephanov.moviecloud.view.ui.fragments.MoviesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, ViewModelFactoryModule::class, MoviesModule::class, MovieDetailsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(moviesFragment: MoviesFragment)
    fun inject(movieDetailsFragment: MovieDetailsFragment)
}