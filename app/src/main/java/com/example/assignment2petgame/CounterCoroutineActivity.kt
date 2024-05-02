package com.example.assignment2petgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CounterCoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_coroutine)

        CoroutineScope(Dispatchers.Main).launch{
            countTo100()
        }
    }
    private  suspend fun countTo100(){
        for (i in 1..100){
            println("Count: $i")
            delay(100)
        }
    }
}