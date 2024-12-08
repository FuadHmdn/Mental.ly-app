package com.c242ps188.mentally_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.c242ps188.mentally_app.data.repository.DiagnoseRepository

class DiagnoseViewModel(private val diagnoseRepository: DiagnoseRepository): ViewModel() {

    var diagnoseProgress = 1
    var gender: Int? = null
    var age: Float? = null
    var workPressure: Float? = null
    var workSatisfied: Float? = null
    var stressLevel: Float? = null
    var dietaryHabits: Float? = null
    var sleepHours: Float? = null
    var workHours: Float? = null
    var selfHarm: Float? = null
    var historyMental: Float? = null
    var depression: Float? = null


}