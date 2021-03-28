package com.alexstephanov.moviecloud.view.ui.lists.pagingsources

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.alexstephanov.moviecloud.api.MovieApiService
import com.alexstephanov.moviecloud.entities.MoviesResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesPagingSource @Inject constructor(
    private val movieApiService: MovieApiService
) : RxPagingSource<Int, MoviesResponse.MovieModel>() {

    override fun getRefreshKey(state: PagingState<Int, MoviesResponse.MovieModel>): Int? {
        TODO("Not yet implemented")
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, MoviesResponse.MovieModel>> {
        val position = params.key ?: 1

        return movieApiService.getMovies(position)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, position) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: MoviesResponse, position: Int): LoadResult<Int, MoviesResponse.MovieModel> {
        return LoadResult.Page(
            data = data.movies,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position == data.totalPages) null else position + 1
        )
    }
}