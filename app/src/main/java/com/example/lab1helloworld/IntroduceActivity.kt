package com.example.lab1helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntroduceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce)

        val input = findViewById<EditText>(R.id.inputName)
        val button = findViewById<Button>(R.id.btnWitaj)
        val result = findViewById<TextView>(R.id.resultText)

        button.setOnClickListener {
            val text = input.text.toString().trim()

            if (text.isEmpty()) {
                result.text = "Przedstaw się."
            } else {
                result.text = "Witaj $text"
            }
        }
    }
}