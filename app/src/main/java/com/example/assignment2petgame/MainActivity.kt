package com.example.assignment2petgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var newStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newStart = findViewById(R.id.startbttn)

        newStart.setOnClickListener {

            val intent2 = Intent(this, testduck::class.java)

            startActivity(intent2)
        }

    }
}