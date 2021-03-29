package com.alexstephanov.moviecloud.api

import com.alexstephanov.moviecloud.BuildConfig
import com.alexstephanov.moviecloud.entities.MovieDetailsModel
import com.alexstephanov.moviecloud.entities.MoviesResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    fun getMovies(@Query("page") page: Int, @Query("api_key") apiKey: String = BuildConfig.API_KEY): Single<MoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Long, @Query("api_key") apiKey: String = BuildConfig.API_KEY): Single<MovieDetailsModel>
}