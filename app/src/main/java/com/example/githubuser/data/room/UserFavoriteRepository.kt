package com.example.githubuser.data.room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class UserFavoriteRepository(private val userFavoriteDao: FavUserDao) {

    val userFavorite: kotlinx.coroutines.flow.Flow<List<FavUserModel>> = userFavoriteDao.getAll();

    @WorkerThread
    fun insert(favUserModel: FavUserModel) {
        userFavoriteDao.insertAll(favUserModel)
    }

    @WorkerThread
    fun delete(favUserModel: FavUserModel) {
        userFavoriteDao.delete(favUserModel)
    }

    @WorkerThread
    fun findByUsername(username: String): Flow<FavUserModel?> {
        return userFavoriteDao.findByName(username)
    }


}