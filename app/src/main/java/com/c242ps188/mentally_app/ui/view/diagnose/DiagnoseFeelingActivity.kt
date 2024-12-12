package com.c242ps188.mentally_app.ui.view.diagnose

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.C242PS188.mentally_app.R
import com.C242PS188.mentally_app.databinding.ActivityDiagnoseFeelingBinding

class DiagnoseFeelingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnoseFeelingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnoseFeelingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        setListener()
    }

    private fun setListener() {
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.edInputText.addTextChangedListener { editable ->
            editable?.let {
                val text = it.toString()
                val words = text.trim().split("\\s+".toRegex())
                if (words.size > 100) {
                    val limitedText = words.take(100).joinToString(" ")
                    binding.edInputText.setText(limitedText)
                    binding.edInputText.setSelection(limitedText.length)
                }
            }
        }

        binding.btnPredict.setOnClickListener {

        }
    }
}