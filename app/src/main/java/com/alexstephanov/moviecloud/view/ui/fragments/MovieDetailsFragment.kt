package com.alexstephanov.moviecloud.view.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alexstephanov.moviecloud.BuildConfig
import com.alexstephanov.moviecloud.MovieCloudApplication
import com.alexstephanov.moviecloud.R
import com.alexstephanov.moviecloud.databinding.FragmentMovieDetailsBinding
import com.alexstephanov.moviecloud.entities.MovieDetailsModel
import com.alexstephanov.moviecloud.view.ui.fragments.viewbinding.viewBinding
import com.alexstephanov.moviecloud.view.viewmodels.MovieDetailsViewModel
import com.alexstephanov.moviecloud.view.viewmodels.factories.MovieDetailsViewModelFactory
import com.alexstephanov.moviecloud.view.viewmodels.factories.ViewModelFactory
import javax.inject.Inject

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private val binding by viewBinding(FragmentMovieDetailsBinding::bind)

    @Inject
    lateinit var viewModelFactory: MovieDetailsViewModelFactory
    private val movieDetailsViewModel: MovieDetailsViewModel by lazy {
        viewModelFactory.create(requireArguments().getLong("MOVIE_ID"))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as MovieCloudApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieDetailsViewModel.movieDetailsLiveData.observe(viewLifecycleOwner) { movieDetails ->
            setupLayout(movieDetails)
        }
    }

    private fun setupLayout(movie: MovieDetailsModel) {
        with(binding) {
            imageViewMovieBanner.setImageURI("${BuildConfig.IMAGES_URL}${movie.bannerPath}")
            imageViewMoviePoster.setImageURI("${BuildConfig.IMAGES_URL}${movie.posterPath}")
            textViewMovieTitle.text = movie.title
            textViewMovieOverview.text = movie.overview
        }
    }
}