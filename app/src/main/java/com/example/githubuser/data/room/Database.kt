package com.example.githubuser.data.room

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


object Database {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    private val NIGHT_MODE = booleanPreferencesKey("night_mode")

    fun getDatabase(applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "fav-user-database"
    ).build()


    suspend fun isDarkMode(context: Context): Boolean {
        return context.dataStore.data.map { preference ->
            preference[NIGHT_MODE] ?: false
        }.first()
    }

    suspend fun setDarkMode(context: Context, isDarkMode: Boolean) {
        context.dataStore.edit { settings ->
            settings[NIGHT_MODE] = isDarkMode
        }
    }
}