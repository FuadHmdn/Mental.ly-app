package com.c242ps188.mentally_app.di

import android.content.Context
import com.c242ps188.mentally_app.data.repository.DiagnoseRepository
import com.c242ps188.mentally_app.ui.viewmodel.DiagnoseViewModel

object Injection {

    fun provideDiagnoseRepository(context: Context): DiagnoseRepository {
        return DiagnoseRepository()
    }

}