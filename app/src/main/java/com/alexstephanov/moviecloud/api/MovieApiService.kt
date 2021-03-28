package com.alexstephanov.moviecloud.api

import com.alexstephanov.moviecloud.BuildConfig
import com.alexstephanov.moviecloud.entities.MoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @FormUrlEncoded
    @GET("movie/popular")
    fun getMovies(@Query("page") page: Int, @Query("api_key") apiKey: String = BuildConfig.API_KEY): Single<MoviesResponse>
}