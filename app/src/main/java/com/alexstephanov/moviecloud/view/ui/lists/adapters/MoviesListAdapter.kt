package com.alexstephanov.moviecloud.view.ui.lists.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alexstephanov.moviecloud.R
import com.alexstephanov.moviecloud.databinding.MovieItemBinding
import com.alexstephanov.moviecloud.entities.MoviesResponse
import com.alexstephanov.moviecloud.view.ui.lists.listeners.OnMovieClickListener

class MoviesListAdapter(private val listener: OnMovieClickListener) :
    PagingDataAdapter<MoviesResponse.MovieModel, MoviesListAdapter.MovieViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder.create(parent, listener)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { movie ->
            holder.bind(movie)
        }
    }

    class MovieViewHolder(private val binding: MovieItemBinding, private val listener: OnMovieClickListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MoviesResponse.MovieModel) {
            with(binding) {
                imageViewMoviePoster.setImageURI("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                textViewMovieTitle.text = movie.title
                layoutMovieItem.setOnClickListener { listener.onMovieClick(movie) }
            }
        }

        companion object {
            fun create(parent: ViewGroup, listener: OnMovieClickListener): MovieViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
                val binding = MovieItemBinding.bind(view)
                return MovieViewHolder(binding, listener)
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<MoviesResponse.MovieModel>() {
            override fun areItemsTheSame(
                oldItem: MoviesResponse.MovieModel,
                newItem: MoviesResponse.MovieModel
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MoviesResponse.MovieModel,
                newItem: MoviesResponse.MovieModel
            ): Boolean =
                oldItem == newItem
        }
    }
}