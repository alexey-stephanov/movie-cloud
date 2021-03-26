package com.alexstephanov.moviecloud.di

import androidx.lifecycle.ViewModelProvider
import com.alexstephanov.moviecloud.view.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {
    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}