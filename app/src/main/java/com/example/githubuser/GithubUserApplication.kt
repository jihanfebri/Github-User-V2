package com.example.githubuser

import android.app.Application
import com.example.githubuser.data.room.Database
import com.example.githubuser.data.room.UserFavoriteRepository

class GithubUserApplication : Application() {

    val database by lazy { Database.getDatabase(this) }
    val repository by lazy { UserFavoriteRepository(database.favUserDao()) }

}