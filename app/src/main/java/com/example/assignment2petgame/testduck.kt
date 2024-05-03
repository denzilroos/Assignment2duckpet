package com.example.assignment2petgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class testduck : AppCompatActivity() {
    private lateinit var hungerAmount: ProgressBar
    private lateinit var countTextView: TextView
    private lateinit var feedbut: Button
    private lateinit var cleanbut: Button
    private lateinit var playwithbut: Button
    private lateinit var cleanTextView: TextView
    private lateinit var happyTextView: TextView
    private lateinit var duckdirtimg : ImageView
    private lateinit var duckfeedimg : ImageView
    private lateinit var duckplayimg : ImageView
    private lateinit var cleanprogress : ProgressBar
    private lateinit var playprogress : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_testduck)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        countTextView = findViewById(R.id.textView2)
        cleanTextView = findViewById(R.id.textView3)
        feedbut = findViewById(R.id.button)
        cleanbut = findViewById(R.id.button2)
        playwithbut = findViewById(R.id.button3)
        happyTextView = findViewById(R.id.textView4)
        hungerAmount = findViewById(R.id.progressBar)
        duckdirtimg = findViewById(R.id.duckDirt)
        duckfeedimg = findViewById(R.id.duckfeed)
        duckplayimg = findViewById(R.id.duckplay)
        cleanprogress = findViewById(R.id.progressBar2)
        playprogress = findViewById(R.id.progressBar3)

        // Start decreasing the number from 100 to 0
        CoroutineScope(Dispatchers.Main).launch {
            decreaseFrom100()

        }
        CoroutineScope(Dispatchers.Main).launch {
            decreaseclean()

        }
        CoroutineScope(Dispatchers.Main).launch {
            decreasehappy()

        }

    }

    private suspend fun decreaseFrom100() {
        var enumber = 100
        var enumstr: String

        feedbut.setOnClickListener {
            duckdirtimg.visibility = View.INVISIBLE
            duckplayimg.visibility = View.INVISIBLE
            duckfeedimg.visibility = View.VISIBLE
            enumber += 50
            if (enumber > 100) {
                enumber = 100
            }

        }
        while (enumber > 0) {
            enumber -= 1
            if (enumber < 5) {
                enumber = 5
            }
            enumstr = enumber.toString()
            countTextView.text = enumstr
            hungerAmount.progress = enumber
            delay(1000) // Delay for 100 milliseconds
        }
    }

    private suspend fun decreaseclean() {
        var enumber2 = 100
        var enumstr2: String

        cleanbut.setOnClickListener {
            duckdirtimg.visibility = View.VISIBLE
            duckplayimg.visibility = View.INVISIBLE
            duckfeedimg.visibility = View.INVISIBLE
            enumber2 += 50
            if (enumber2 > 100) {
                enumber2 = 100
            }

        }





        while (enumber2 > 0) {
            enumber2 -= 1
            if (enumber2 < 5) {
                enumber2 = 5
            }
            enumstr2 = enumber2.toString()
            cleanTextView.text = enumstr2
            cleanprogress.progress = enumber2

            delay(1000) // Delay for 100 milliseconds
        }
    }

    private suspend fun decreasehappy() {
        var enumber3 = 100
        var enumstr3: String

        playwithbut.setOnClickListener {
            duckdirtimg.visibility = View.INVISIBLE
            duckplayimg.visibility = View.VISIBLE
            duckfeedimg.visibility = View.INVISIBLE
            enumber3 += 50
            if (enumber3 > 100) {
                enumber3 = 100
            }

        }
        while (enumber3 > 0) {
            enumber3 -= 1
            if (enumber3 < 5) {
                enumber3 = 5
            }
            enumstr3 = enumber3.toString()
            happyTextView.text = enumstr3
            playprogress.progress = enumber3

            delay(1000) // Delay for 100 milliseconds
        }

    }
    }
