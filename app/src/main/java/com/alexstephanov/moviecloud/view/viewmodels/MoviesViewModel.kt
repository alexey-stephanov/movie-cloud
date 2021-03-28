package com.alexstephanov.moviecloud.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import androidx.paging.rxjava2.observable
import com.alexstephanov.moviecloud.entities.MoviesResponse
import com.alexstephanov.moviecloud.repositories.MoviesRepository
import io.reactivex.Observable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val moviesRepository: MoviesRepository) : ViewModel() {

    @ExperimentalCoroutinesApi
    fun getPopularMovies(): Observable<PagingData<MoviesResponse.MovieModel>> =
        moviesRepository
            .getMovies()
            .observable
            .cachedIn(viewModelScope)
}