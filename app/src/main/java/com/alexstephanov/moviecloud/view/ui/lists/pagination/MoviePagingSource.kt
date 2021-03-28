package com.alexstephanov.moviecloud.view.ui.lists.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexstephanov.moviecloud.api.MovieApiService
import com.alexstephanov.moviecloud.entities.MoviesResponse

class MoviePagingSource(
    val movieApiService: MovieApiService
): PagingSource<Int, MoviesResponse>() {
    override fun getRefreshKey(state: PagingState<Int, MoviesResponse>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesResponse> {
        TODO("Not yet implemented")
    }

}