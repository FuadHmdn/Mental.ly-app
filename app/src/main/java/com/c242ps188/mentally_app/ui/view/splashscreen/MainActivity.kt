package com.c242ps188.mentally_app.ui.view.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.C242PS188.mentally_app.R
import com.c242ps188.mentally_app.ui.view.home.HomeActivity
import com.c242ps188.mentally_app.ui.view.login.LoginActivity
import com.c242ps188.mentally_app.ui.viewmodel.UsersViewModel
import com.c242ps188.mentally_app.ui.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val factory: ViewModelFactory by lazy {
        ViewModelFactory.getInstance(this)
    }
    private val usersViewModel: UsersViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            usersViewModel.getToken.observe(this@MainActivity){ token ->
                if (token.isNullOrEmpty()) {
                    val intent = Intent(this@MainActivity, LoginActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                } else {
                    val intent = Intent(this@MainActivity, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                }
            }
        }
    }
}