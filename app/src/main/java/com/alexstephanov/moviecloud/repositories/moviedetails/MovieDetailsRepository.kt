package com.alexstephanov.moviecloud.repositories.moviedetails

import com.alexstephanov.moviecloud.entities.MovieDetailsModel
import io.reactivex.Single

interface MovieDetailsRepository {
    fun getMovieDetails(movieId: Long): Single<MovieDetailsModel>
}