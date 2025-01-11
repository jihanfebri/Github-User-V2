package com.example.githubuser.ui.favorite

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.githubuser.data.room.AppDatabase
import com.example.githubuser.data.room.Database
import com.example.githubuser.data.room.FavUserDao
import com.example.githubuser.data.room.FavUserModel
import com.example.githubuser.data.room.UserFavoriteRepository

class FavoriteViewModel(private val userFavoriteRepository: UserFavoriteRepository) : ViewModel() {
    private lateinit var db: AppDatabase
    private lateinit var userDao: FavUserDao

    val listUser: LiveData<List<FavUserModel>> = userFavoriteRepository.userFavorite.asLiveData();

    fun initiateDatabase(context: Context) {
        db = Database.getDatabase(context)
        userDao = db.favUserDao()
    }

    fun insert(userFavorite: FavUserModel) {
        userFavoriteRepository.insert(userFavorite)
    }

    fun delete(userFavorite: FavUserModel) {
        userFavoriteRepository.delete(userFavorite)
    }

    fun findByUsername(username: String): LiveData<FavUserModel?> {
        return userFavoriteRepository.findByUsername(username).asLiveData()
    }

}

class FavoriteViewModelFactory(private val repository: UserFavoriteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}