package com.example.inf04_02_2501_sg

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    var vacuumState = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numberOfWashing = findViewById<EditText>(R.id.numOfWashing)
        val numerOfWashingText = findViewById<TextView>(R.id.numOfWashingText)
        val statusOfVacuumText = findViewById<TextView>(R.id.statusOfVacuumText)
        val startButton = findViewById<Button>(R.id.startVacuumButton)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val cleaningSlider = findViewById<Slider>(R.id.cleaningMinutesSlider)
        val cleaningText = findViewById<TextView>(R.id.cleaningMinutesText)

        submitButton.setOnClickListener {
            val washingNum = numberOfWashing.text
            numerOfWashingText.text = "Numer prania: $washingNum"
        }

        startButton.setOnClickListener {
            vacuumState = !vacuumState

            if (vacuumState) {
                startButton.text = "WYŁĄCZ"
                statusOfVacuumText.text = "Odkurzacz włączony"
            } else {
                startButton.text = "WŁĄCZ"
                statusOfVacuumText.text = "Odkurzacz wyłączony"
            }
        }

        cleaningSlider.addOnChangeListener { _, value, _ ->
            cleaningText.text = "Czas zmywania ${value.toInt()} min"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}