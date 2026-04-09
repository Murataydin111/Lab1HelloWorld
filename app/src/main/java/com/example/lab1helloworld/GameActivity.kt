package com.example.lab1helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var randomNumber = 0
    private var attempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val input = findViewById<EditText>(R.id.inputGuess)
        val button = findViewById<Button>(R.id.btnGuess)
        val result = findViewById<TextView>(R.id.resultGame)

        startNewGame()

        button.setOnClickListener {

            val text = input.text.toString().trim()

            if (text.isEmpty()) {
                result.text = "Please enter an integer number."
                return@setOnClickListener
            }

            val guess = text.toIntOrNull()
            if (guess == null) {
                result.text = "Please enter an integer number."
                return@setOnClickListener
            }

            if (guess !in 1..10) {
                result.text = "Number must be in range 1..10."
                return@setOnClickListener
            }

            attempts++

            if (guess < randomNumber) {
                result.text = "Value too small"
            } else if (guess > randomNumber) {
                result.text = "Value too large"
            } else {
                if (attempts == 2) {
                    result.text = "Correct — achieved on the 2nd attempt"
                } else {
                    result.text = "Correct, but not on the 2nd attempt. Try again."
                    startNewGame()
                }
            }
        }
    }

    private fun startNewGame() {
        randomNumber = Random.nextInt(1, 11)
        attempts = 0
    }
}