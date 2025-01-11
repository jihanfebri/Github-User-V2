package com.example.githubuser.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.githubuser.GithubUserApplication
import com.example.githubuser.R
import com.example.githubuser.data.response.DetailUserResponse
import com.example.githubuser.data.room.FavUserModel
import com.example.githubuser.databinding.ActivityDetailBinding
import com.example.githubuser.ui.SectionsPagerAdapter
import com.example.githubuser.ui.favorite.FavoriteViewModel
import com.example.githubuser.ui.favorite.FavoriteViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private val detailViewModel by viewModels<DetailViewModel>()
    private var isFollowed = false;
    private lateinit var userFavorite: FavUserModel


    private val viewModel: FavoriteViewModel by viewModels {
        FavoriteViewModelFactory((application as GithubUserApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailViewModel.initiateDatabase(context = this)

        sectionsPagerAdapter = SectionsPagerAdapter(this)
        sectionsPagerAdapter.username = intent.getStringExtra("user_login").toString()

        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = binding.tabs

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            if (position == 0) {
                tab.text = "Follower"
            } else {
                tab.text = "Following"
            }
        }.attach()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val userLogin = intent.getStringExtra("user_login")
        val userAvatar = intent.getStringExtra("user_avatar")
        val userId = intent.getStringExtra("user_id")


        if (userLogin != null) {
            detailViewModel.findDetailUser(userLogin)
            detailViewModel.findFollowers(userLogin)
            viewModel.findByUsername(userLogin).observe(this) { userFavorite ->
                if (userFavorite != null) {
                    isFollowed = true
                    this.userFavorite = userFavorite
                    binding.fabFavorite.setImageResource(R.drawable.baseline_favorite_24)
                } else {
                    isFollowed = false
                    binding.fabFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
                }
            }
        }

        Log.d("sat", "onCreate: $userLogin")
        if (userLogin != null) {
            detailViewModel.findDetailUser(userLogin)
            detailViewModel.findFollowers(userLogin)
            detailViewModel.checkExisted(userLogin)
        }

        detailViewModel.listDetailUser.observe(this) { listDetailUser ->
            setDetailUserData(listDetailUser)
        }

        detailViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        binding.fabFavorite.setOnClickListener(View.OnClickListener {
            if (userLogin != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    if (isFollowed) {
                        viewModel.delete(userFavorite)
                    } else {
                        Log.i("User favorite", "onCreate: $userId - $userLogin - $userAvatar")
                        val favUserModel: FavUserModel =
                            FavUserModel((0..1000).random(), userLogin, userAvatar!!)
                        viewModel.insert(favUserModel)
                    }
                }
            }
        })


    }

    private fun setDetailUserData(listDetailUser: DetailUserResponse) {
        binding.tvName.text = listDetailUser.name
        binding.tvLogin.text = listDetailUser.login
        Glide.with(this@DetailActivity).load("${listDetailUser.avatarUrl}?v=4")
            .into(binding.imgItemUser)
        binding.tvFollowers.text = listDetailUser.followers.toString()
        binding.tvFollowing.text = listDetailUser.following.toString()
    }

    private fun showLoading(state: Boolean) {
        binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }
}