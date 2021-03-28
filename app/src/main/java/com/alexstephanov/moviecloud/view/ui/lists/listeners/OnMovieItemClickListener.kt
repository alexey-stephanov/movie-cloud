package com.alexstephanov.moviecloud.view.ui.lists.listeners

import com.alexstephanov.moviecloud.entities.MoviesResponse.MovieModel

interface OnMovieClickListener {
    fun onMovieClick(movie: MovieModel)
}