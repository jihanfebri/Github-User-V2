package com.example.githubuser.ui.setting

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuser.data.room.Database
import kotlinx.coroutines.launch

class SettingViewModel : ViewModel() {
    private val _isDarkMode = MutableLiveData<Boolean>()
    val isDarkMode: LiveData<Boolean> = _isDarkMode

    fun getDarkMode(context: Context) {
        viewModelScope.launch {
            _isDarkMode.value = Database.isDarkMode(context)
        }
    }

    fun setDarkMode(context: Context, isDarkMode: Boolean) {
        viewModelScope.launch {
            Database.setDarkMode(context, isDarkMode)
        }
    }
}