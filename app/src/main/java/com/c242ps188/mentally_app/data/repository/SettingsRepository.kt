package com.c242ps188.mentally_app.data.repository

import com.c242ps188.mentally_app.data.local.preferences.SettingsPreferences
import kotlinx.coroutines.flow.Flow

class SettingsRepository(
    private val settingsPreferences: SettingsPreferences
) {

    fun getTheme(): Flow<Boolean> {
        return settingsPreferences.getTheme()
    }

    fun getLanguage(): Flow<String> {
        return settingsPreferences.getLanguage()
    }

    suspend fun setTheme(isDarkMode: Boolean){
        settingsPreferences.setTheme(isDarkMode)
    }

    suspend fun setLanguage(language: String){
        settingsPreferences.setLanguage(language)
    }

}