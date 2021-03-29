package com.alexstephanov.moviecloud.view.viewmodels.factories

import com.alexstephanov.moviecloud.repositories.moviedetails.MovieDetailsRepository
import com.alexstephanov.moviecloud.view.viewmodels.MovieDetailsViewModel
import javax.inject.Inject

class MovieDetailsViewModelFactory @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) {
    fun create(movieId: Long): MovieDetailsViewModel = MovieDetailsViewModel(movieDetailsRepository, movieId)
}