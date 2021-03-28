package com.alexstephanov.moviecloud.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.alexstephanov.moviecloud.MovieCloudApplication
import com.alexstephanov.moviecloud.R
import com.alexstephanov.moviecloud.view.ui.fragments.MoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MovieCloudApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            add(R.id.fragment_container, MoviesFragment())
            setReorderingAllowed(true)
        }
    }
}