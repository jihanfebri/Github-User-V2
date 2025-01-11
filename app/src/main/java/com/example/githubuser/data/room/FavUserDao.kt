package com.example.githubuser.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavUserDao {
    @Query("SELECT * FROM favusermodel")
    fun getAll(): Flow<List<FavUserModel>>

    @Query("SELECT * FROM favusermodel WHERE userName LIKE :userName LIMIT 1")
    fun findByName(userName: String): Flow<FavUserModel?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: FavUserModel)

    @Delete
    fun delete(user: FavUserModel)
}