package com.alexstephanov.moviecloud.entities

import com.google.gson.annotations.SerializedName

data class MovieDetailsModel(
    @SerializedName("id")
    val movieId: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("backdrop_path")
    val bannerPath: String,
    @SerializedName("vote_average")
    val averageVote: Double
)