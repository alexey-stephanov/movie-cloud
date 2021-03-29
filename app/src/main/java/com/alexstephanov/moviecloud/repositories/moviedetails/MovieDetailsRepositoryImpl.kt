package com.alexstephanov.moviecloud.repositories.moviedetails

import com.alexstephanov.moviecloud.api.MovieApiService
import com.alexstephanov.moviecloud.entities.MovieDetailsModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(private val movieApiService: MovieApiService) :
    MovieDetailsRepository {
    override fun getMovieDetails(movieId: Long): Single<MovieDetailsModel> =
        movieApiService.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
}