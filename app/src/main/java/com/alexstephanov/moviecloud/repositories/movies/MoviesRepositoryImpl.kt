package com.alexstephanov.moviecloud.repositories.movies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.alexstephanov.moviecloud.entities.MoviesResponse
import com.alexstephanov.moviecloud.view.ui.lists.pagingsources.MoviesPagingSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesPagingSource: MoviesPagingSource) :
    MoviesRepository {
    @ExperimentalCoroutinesApi
    override fun getMovies(): Pager<Int, MoviesResponse.MovieModel> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { moviesPagingSource }
        )
    }
}