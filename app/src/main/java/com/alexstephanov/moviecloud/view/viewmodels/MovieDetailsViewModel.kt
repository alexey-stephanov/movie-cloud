package com.alexstephanov.moviecloud.view.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexstephanov.moviecloud.entities.MovieDetailsModel
import com.alexstephanov.moviecloud.repositories.moviedetails.MovieDetailsRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class MovieDetailsViewModel(
    movieDetailsRepository: MovieDetailsRepository,
    movieId: Long
) : ViewModel() {

    private val disposable = CompositeDisposable()

    val movieDetailsLiveData: MutableLiveData<MovieDetailsModel> = MutableLiveData()

    init {
        disposable.add(movieDetailsRepository.getMovieDetails(movieId).subscribe(
                {
                    movieDetailsLiveData.postValue(it)
                }, {
                    Timber.e("Error with $it")
                })
        )
    }

    override fun onCleared() {
        disposable.dispose()

        super.onCleared()
    }
}