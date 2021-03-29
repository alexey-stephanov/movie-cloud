package com.alexstephanov.moviecloud.di

import androidx.lifecycle.ViewModelProvider
import com.alexstephanov.moviecloud.view.viewmodels.factories.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ViewModelFactoryModule {
    @Singleton
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}