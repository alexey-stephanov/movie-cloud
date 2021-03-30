package com.alexstephanov.moviecloud.view.ui.lists.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexstephanov.moviecloud.databinding.LoadStateItemBinding

class LoaderStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<LoaderStateAdapter.LoaderViewHolder>() {

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        val binding = LoadStateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoaderViewHolder(binding, retry)
    }

    class LoaderViewHolder(
        private val binding: LoadStateItemBinding,
        private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            with(binding) {
                groupLoadStateError.isVisible = loadState !is LoadState.Loading
                progressBarLoadStateItemLoading.isVisible = loadState is LoadState.Loading
                buttonLoadStateItemRetry.setOnClickListener { retry() }
            }
        }
    }
}