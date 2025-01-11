package com.example.githubuser.ui.favorite

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.GithubUserApplication
import com.example.githubuser.databinding.ActivityFavoriteBinding
import com.example.githubuser.ui.UserFavoriteAdapter

class FavoriteActivity : AppCompatActivity() {

    private val viewModel: FavoriteViewModel by viewModels {
        FavoriteViewModelFactory((application as GithubUserApplication).repository)
    }

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Favorite User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.initiateDatabase(this)

        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvUser.addItemDecoration(itemDecoration)

        viewModel.listUser.observe(this) {
            val adapter = UserFavoriteAdapter(it)
            binding.rvUser.adapter = adapter
        }
    }
}