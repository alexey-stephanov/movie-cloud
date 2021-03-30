package com.alexstephanov.moviecloud.entities

import com.google.gson.annotations.SerializedName

data class MovieDetailsModel(
    @SerializedName("id")
    val movieId: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("backdrop_path")
    val bannerPath: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("genres")
    val genres: List<GenresModel>,
    @SerializedName("vote_average")
    val averageVote: Double
) {
    data class GenresModel(
        @SerializedName("name")
        val genreName: String
    )
}