package com.alexstephanov.moviecloud.repositories

import androidx.paging.Pager
import androidx.paging.PagingData
import com.alexstephanov.moviecloud.entities.MoviesResponse
import io.reactivex.Flowable

interface MoviesRepository {
    fun getMovies(): Pager<Int, MoviesResponse.MovieModel>
}