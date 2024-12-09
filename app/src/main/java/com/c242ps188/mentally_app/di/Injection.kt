package com.c242ps188.mentally_app.di

import android.content.Context
import com.c242ps188.mentally_app.data.local.preferences.SettingsPreferences
import com.c242ps188.mentally_app.data.local.preferences.dataStore
import com.c242ps188.mentally_app.data.repository.DiagnoseRepository
import com.c242ps188.mentally_app.data.repository.SettingsRepository

object Injection {

    fun provideDiagnoseRepository(context: Context): DiagnoseRepository {
        return DiagnoseRepository()
    }

    fun provideSettingsRepository(context: Context): SettingsRepository {
        val pref = SettingsPreferences.getInstance(context.applicationContext.dataStore, context.applicationContext)
        return SettingsRepository(pref)
    }

}