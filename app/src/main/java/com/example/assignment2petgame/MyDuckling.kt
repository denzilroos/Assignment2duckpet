package com.example.assignment2petgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.*


@OptIn(DelicateCoroutinesApi::class)
class MyDuckling : AppCompatActivity() {


    lateinit var hungerAmount: ProgressBar
    lateinit var tenSec: TextView
    private lateinit var countTextView: TextView
    private lateinit var feedbut : Button
    private lateinit var cleanbut : Button
    private lateinit var cleanTextView : TextView
    private lateinit var happyTextView : TextView
    private lateinit var playwithbut : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_duckling)


        countTextView = findViewById(R.id.textTime)
        cleanTextView = findViewById(R.id.cleanamount)
        feedbut = findViewById(R.id.feedbtn)
        cleanbut = findViewById(R.id.cleanbtn)
        playwithbut = findViewById(R.id.playbtn)
        happyTextView = findViewById(R.id.happyText)

        hungerAmount = findViewById(R.id.progressBarhunger)



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
        var enumstr :String

        feedbut.setOnClickListener{
            enumber += 50
            if (enumber > 100){
                enumber = 100
            }

        }
        while (enumber > 0 ) {
            enumber -= 1
            if (enumber < 5) {
                enumber = 5
            }
            enumstr = enumber.toString()
            countTextView.text = enumstr
hungerAmount.progress = enumber
            delay(100) // Delay for 100 milliseconds
        }
    }
    private suspend fun decreaseclean() {
        var enumber2 = 100
        var enumstr2 :String

        cleanbut.setOnClickListener{
            enumber2 += 50
            if (enumber2 > 100){
                enumber2 = 100
            }

        }
        while (enumber2 > 0 ) {
            enumber2 -= 1
            if (enumber2 < 5) {
                enumber2 = 5
            }
            enumstr2 = enumber2.toString()
            cleanTextView.text = enumstr2

            delay(100) // Delay for 100 milliseconds
        }
    }
    private suspend fun decreasehappy() {
        var enumber3 = 100
        var enumstr3 :String

        playwithbut.setOnClickListener{
            enumber3 += 50
            if (enumber3 > 100){
                enumber3 = 100
            }

        }
        while (enumber3 > 0 ) {
            enumber3 -= 1
            if (enumber3 < 5) {
                enumber3 = 5
            }
            enumstr3 = enumber3.toString()
            happyTextView.text = enumstr3

            delay(100) // Delay for 100 milliseconds
        }
    }
}


        /* suspend fun main() {
             tenSec = findViewById(R.id.textTime)


             var number: Int = 0
                     var numasstr : String
             while (true) {
                 // Increase the number by 10
                 number += 10
                 numasstr = number.toString()
                 tenSec.text = numasstr
                 delay(1000) // Delay for 1 second
             }

         }
 GlobalScope.launch { main() }
         runBlocking {
             delay(Long.MAX_VALUE)
         }*/









