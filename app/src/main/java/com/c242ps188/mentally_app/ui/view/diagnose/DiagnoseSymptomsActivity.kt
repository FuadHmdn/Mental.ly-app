package com.c242ps188.mentally_app.ui.view.diagnose

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.C242PS188.mentally_app.R
import com.C242PS188.mentally_app.databinding.ActivityDiagnoseSymptomsBinding

class DiagnoseSymptomsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnoseSymptomsBinding
    private val ageOptions = (10..45).map { it.toString() }
    private var diagnoseProgress = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnoseSymptomsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        setListener()
        updateUI()
    }

    private fun updateUI() {
        when (diagnoseProgress) {
            1 -> {
                binding.diagnose1.visibility = View.VISIBLE
                binding.diagnose2.visibility = View.GONE
                binding.btnStart.visibility = View.VISIBLE
                Log.d("DIAGNOSE", binding.diagnose2.visibility.toString())
            }
            2 -> {
                binding.diagnose2.visibility = View.VISIBLE
                binding.diagnose1.visibility = View.GONE
                binding.btnStart.visibility = View.VISIBLE
                Log.d("DIAGNOSE", binding.diagnose2.visibility.toString())
            }
        }
    }


    private fun setListener() {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            ageOptions
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerAge.adapter = adapter

        binding.spinnerAge.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val age = parent?.getItemAtPosition(position).toString()
                showToast(age)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.radioGroupGender.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radio_male -> {

                }
                R.id.radio_female -> {

                }
            }
        }

        binding.btnStart.setOnClickListener {
            diagnoseProgress = 2
            updateUI()
            binding.diagnose2.visibility = View.VISIBLE
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this@DiagnoseSymptomsActivity, message, Toast.LENGTH_LONG).show()
    }
}