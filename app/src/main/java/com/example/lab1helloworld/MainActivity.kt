package com.example.lab1helloworld

// Name: Murat Aydın
// Student ID: 56429
// Lab: 1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Introduce Activity butonu
        val btnIntroduce = findViewById<Button>(R.id.goIntroduce)
        btnIntroduce.setOnClickListener {
            val intent = Intent(this, IntroduceActivity::class.java)
            startActivity(intent)
        }

        // Game Activity butonu
        val btnGame = findViewById<Button>(R.id.goGame)
        btnGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        // Sistem padding (opsiyonel ama iyi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}