package com.c242ps188.mentally_app.ui.view.diagnose

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.C242PS188.mentally_app.R
import com.C242PS188.mentally_app.databinding.ActivityDiagnoseSymptomsBinding
import com.c242ps188.mentally_app.ui.viewmodel.DiagnoseViewModel
import com.c242ps188.mentally_app.ui.viewmodel.ViewModelFactory

class DiagnoseSymptomsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnoseSymptomsBinding
    private val ageOptions = (10..45).map { it.toString() }
    private val factory: ViewModelFactory by lazy {
        ViewModelFactory.getInstance(this)
    }
    private val diagnoseViewModel: DiagnoseViewModel by viewModels { factory }

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
        when (diagnoseViewModel.diagnoseProgress) {
            1 -> {
                binding.diagnose1.visibility = View.VISIBLE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose3.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.btnNext.visibility = View.VISIBLE
                binding.btnBackDiagnose.visibility = View.GONE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
            }
            2 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose2.visibility = View.VISIBLE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
            }
            3 -> {
                binding.diagnose3.visibility = View.VISIBLE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
            }
            4 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.VISIBLE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
            }
            5 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.VISIBLE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
            }
            6 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose6.visibility = View.VISIBLE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
            }
            7 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose1.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose7.visibility = View.VISIBLE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
            }
            8 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.VISIBLE
                binding.diagnose9.visibility = View.GONE
                binding.diagnose10.visibility = View.GONE
            }
            9 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose9.visibility = View.VISIBLE
                binding.diagnose10.visibility = View.GONE
            }
            10 -> {
                binding.diagnose3.visibility = View.GONE
                binding.diagnose2.visibility = View.GONE
                binding.diagnose4.visibility = View.GONE
                binding.diagnose5.visibility = View.GONE
                binding.diagnose6.visibility = View.GONE
                binding.diagnose1.visibility = View.GONE
                binding.btnBackDiagnose.visibility = View.VISIBLE
                binding.diagnose7.visibility = View.GONE
                binding.diagnose8.visibility = View.GONE
                binding.diagnose9.visibility = View.GONE
                binding.diagnose10.visibility = View.VISIBLE
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

        binding.spinnerAge.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                parent?.let {
                    val inputAge = it.getItemAtPosition(position).toString()
                    diagnoseViewModel.age = inputAge.toFloatOrNull()
                    showToast(diagnoseViewModel.age.toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.radioGroupGender.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_male -> {
                    diagnoseViewModel.gender = 1
                    showToast(diagnoseViewModel.gender.toString())
                }

                R.id.radio_female -> {
                    diagnoseViewModel.gender = 0
                    showToast(diagnoseViewModel.gender.toString())
                }
            }
        }

        // WORK PRESSURE
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_very_low -> {
                    diagnoseViewModel.workPressure = 1F
                    showToast(diagnoseViewModel.workPressure.toString())
                }

                R.id.rb_low -> {
                    diagnoseViewModel.workPressure = 2F
                    showToast(diagnoseViewModel.workPressure.toString())
                }

                R.id.rb_moderate -> {
                    diagnoseViewModel.workPressure = 3F
                    showToast(diagnoseViewModel.workPressure.toString())
                }

                R.id.rb_high -> {
                    diagnoseViewModel.workPressure = 4F
                    showToast(diagnoseViewModel.workPressure.toString())
                }

                R.id.rb_very_high -> {
                    diagnoseViewModel.workPressure = 5F
                    showToast(diagnoseViewModel.workPressure.toString())
                }
            }
        }

        // WORK SATISFIED
        binding.radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_very_low2 -> {
                    diagnoseViewModel.workSatisfied = 1F
                    showToast(diagnoseViewModel.workSatisfied.toString())
                }

                R.id.rb_low2 -> {
                    diagnoseViewModel.workSatisfied = 2F
                    showToast(diagnoseViewModel.workSatisfied.toString())
                }

                R.id.rb_moderate2 -> {
                    diagnoseViewModel.workSatisfied = 3F
                    showToast(diagnoseViewModel.workSatisfied.toString())
                }

                R.id.rb_high2 -> {
                    diagnoseViewModel.workSatisfied = 4F
                    showToast(diagnoseViewModel.workSatisfied.toString())
                }

                R.id.rb_very_high2 -> {
                    diagnoseViewModel.workSatisfied = 5F
                    showToast(diagnoseViewModel.workSatisfied.toString())
                }
            }
        }

        // STRESS LEVEL
        binding.radioGroup3.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_very_low3 -> {
                    diagnoseViewModel.stressLevel = 1F
                    showToast(diagnoseViewModel.stressLevel.toString())
                }

                R.id.rb_low3 -> {
                    diagnoseViewModel.stressLevel = 2F
                    showToast(diagnoseViewModel.stressLevel.toString())
                }

                R.id.rb_moderate3 -> {
                    diagnoseViewModel.stressLevel = 3F
                    showToast(diagnoseViewModel.stressLevel.toString())
                }

                R.id.rb_high3 -> {
                    diagnoseViewModel.stressLevel = 4F
                    showToast(diagnoseViewModel.stressLevel.toString())
                }

                R.id.rb_very_high3 -> {
                    diagnoseViewModel.stressLevel = 5F
                    showToast(diagnoseViewModel.stressLevel.toString())
                }
            }
        }

        // HABITS
        binding.radioGroup4.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_healthy -> {
                    diagnoseViewModel.dietaryHabits = 0F
                    showToast(diagnoseViewModel.dietaryHabits.toString())
                }

                R.id.rb_moderate4 -> {
                    diagnoseViewModel.dietaryHabits = 1F
                    showToast(diagnoseViewModel.dietaryHabits.toString())
                }

                R.id.rb_unHealthy -> {
                    diagnoseViewModel.dietaryHabits = 2F
                    showToast(diagnoseViewModel.dietaryHabits.toString())
                }
            }
        }

        // SLEEP HOURS
        binding.radioGroup5.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_5hours -> {
                    diagnoseViewModel.sleepHours = 0F
                    showToast(diagnoseViewModel.sleepHours.toString())
                }
                R.id.rb_5_6_hourse-> {
                    diagnoseViewModel.sleepHours = 1F
                    showToast(diagnoseViewModel.sleepHours.toString())
                }
                R.id.rb_7_8_hourse -> {
                    diagnoseViewModel.sleepHours = 2F
                    showToast(diagnoseViewModel.sleepHours.toString())
                }
                R.id.rb_8hourse -> {
                    diagnoseViewModel.sleepHours = 3F
                    showToast(diagnoseViewModel.sleepHours.toString())
                }
            }
        }

        // WORK HOURS
        binding.edWorkHours.addTextChangedListener { editable ->
            val workHours = editable?.toString() ?: ""
            diagnoseViewModel.workHours = workHours.toFloatOrNull() ?: 0f
            showToast(workHours)
        }

        // SELF HARM
        binding.radioGroup7.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_yes7 -> {
                    diagnoseViewModel.selfHarm = 1F
                    showToast(diagnoseViewModel.selfHarm.toString())
                }
                R.id.rb_no7 -> {
                    diagnoseViewModel.selfHarm = 0F
                    showToast(diagnoseViewModel.selfHarm.toString())
                }
            }
        }

        // HISTORY MENTAL
        binding.radioGroup8.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_yes8 -> {
                    diagnoseViewModel.historyMental = 1F
                    showToast(diagnoseViewModel.historyMental.toString())
                }
                R.id.rb_no8 -> {
                    diagnoseViewModel.historyMental = 0F
                    showToast(diagnoseViewModel.historyMental.toString())
                }
            }
        }

        // DEPRESSION
        binding.radioGroup9.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_yes9 -> {
                    diagnoseViewModel.depression = 1F
                    showToast(diagnoseViewModel.depression.toString())
                }
                R.id.rb_no9 -> {
                    diagnoseViewModel.depression = 0F
                    showToast(diagnoseViewModel.depression.toString())
                }
            }
        }

        binding.btnNext.setOnClickListener {
            diagnoseViewModel.diagnoseProgress++
            updateUI()
        }

        binding.btnBackDiagnose.setOnClickListener {
            diagnoseViewModel.diagnoseProgress--
            updateUI()
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@DiagnoseSymptomsActivity, message, Toast.LENGTH_SHORT).show()
    }
}