package com.example.carconfigurator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carImageView = findViewById<ImageView>(R.id.carImageView)
        val carTypeGroup = findViewById<RadioGroup>(R.id.carTypeGroup)
        val cbAirConditioning = findViewById<CheckBox>(R.id.cbAirConditioning)
        val cbLeatherSeats = findViewById<CheckBox>(R.id.cbLeatherSeats)
        val btnShowSummary = findViewById<Button>(R.id.btnShowSummary)
        val tvSummary = findViewById<TextView>(R.id.tvSummary)

        carTypeGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbSedan -> carImageView.setImageResource(R.drawable.sedan)
                R.id.rbSUV -> carImageView.setImageResource(R.drawable.suv)
                R.id.rbHatchback -> carImageView.setImageResource(R.drawable.hatchback)
            }
        }

        btnShowSummary.setOnClickListener {
            val selectedCarType = when (carTypeGroup.checkedRadioButtonId) {
                R.id.rbSedan -> "Sedan"
                R.id.rbSUV -> "SUV"
                R.id.rbHatchback -> "Hatchback"
                else -> ""
            }
val options = mutableListOf<String>()
            if (cbAirConditioning.isChecked) options.add("Klimatyzacja")
            if (cbLeatherSeats.isChecked) options.add("Skórzane siedzenia")

            val summary = "Wybrany model: $selectedCarType\nWyposażenie: ${options.joinToString(", ")}"
            tvSummary.text = summary
        }
    }
}
