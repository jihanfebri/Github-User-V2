package com.example.githubuser.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavUserModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val userId: Int,
    @ColumnInfo(name = "userName")
    val userName: String,
    @ColumnInfo(name = "avatarURL")
    val avatarURL: String
)