package com.alexstephanov.moviecloud.view.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.alexstephanov.moviecloud.MovieCloudApplication
import com.alexstephanov.moviecloud.R
import com.alexstephanov.moviecloud.databinding.FragmentMoviesBinding
import com.alexstephanov.moviecloud.view.ui.fragments.viewbinding.viewBinding
import com.alexstephanov.moviecloud.view.ui.lists.adapters.LoaderStateAdapter
import com.alexstephanov.moviecloud.view.ui.lists.adapters.MoviesListAdapter
import com.alexstephanov.moviecloud.view.viewmodels.MoviesViewModel
import com.alexstephanov.moviecloud.view.viewmodels.factories.ViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private val binding by viewBinding(FragmentMoviesBinding::bind)

    private val disposable = CompositeDisposable()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val moviesViewModel: MoviesViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as MovieCloudApplication).appComponent.inject(this)
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moviesListAdapter = MoviesListAdapter {
            val arguments = Bundle()
            arguments.putLong("MOVIE_ID", it.movieId)
            parentFragmentManager.commit {
                replace(R.id.fragment_container, MovieDetailsFragment::class.java, arguments)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                addToBackStack("MovieDetailsFragment")
            }
        }

        binding.recyclerViewMoviesList.apply {
            setHasFixedSize(true)
            adapter = moviesListAdapter.withLoadStateFooter(LoaderStateAdapter { moviesListAdapter.retry() })
        }

        disposable.add(moviesViewModel.getPopularMovies().subscribe {
            moviesListAdapter.submitData(lifecycle, it)
        })
    }

    override fun onDestroyView() {
        disposable.dispose()

        super.onDestroyView()
    }
}