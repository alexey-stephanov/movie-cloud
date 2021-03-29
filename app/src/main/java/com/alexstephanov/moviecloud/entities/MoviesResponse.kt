package com.alexstephanov.moviecloud.entities

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<MovieModel>,
    @SerializedName("total_pages")
    val totalPages: Int
) {
    data class MovieModel(
        @SerializedName("id")
        val movieId: Long,
        @SerializedName("original_title")
        val title: String,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("vote_average")
        val averageVote: String
    )
}