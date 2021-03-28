package com.alexstephanov.moviecloud.entities

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    val id: Long,
    @SerializedName("original_title")
    val title: String,
    @SerializedName("vote_average")
    val averageVote: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>
)