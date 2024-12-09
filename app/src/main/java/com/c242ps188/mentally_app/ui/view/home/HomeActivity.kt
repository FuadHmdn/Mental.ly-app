package com.c242ps188.mentally_app.ui.view.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.C242PS188.mentally_app.R
import com.C242PS188.mentally_app.databinding.ActivityHomeBinding
import com.c242ps188.mentally_app.ui.view.diagnose.DiagnoseSymptomsActivity
import com.c242ps188.mentally_app.ui.view.settings.SettingsActivity
import com.c242ps188.mentally_app.ui.viewmodel.SettingsViewModel
import com.c242ps188.mentally_app.ui.viewmodel.ViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var bindig: ActivityHomeBinding
    private val factory: ViewModelFactory by lazy { ViewModelFactory.getInstance(this) }
    private val settingsViewModel: SettingsViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindig = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        observe()
        setListener()

    }

    private fun observe() {
        settingsViewModel.getTheme.observe(this){ isDarkMode ->
            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun setListener() {
        bindig.settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        bindig.cvDiagnoseFromSymptomps.setOnClickListener {
            val intent = Intent(this, DiagnoseSymptomsActivity::class.java)
            startActivity(intent)
        }
    }
}