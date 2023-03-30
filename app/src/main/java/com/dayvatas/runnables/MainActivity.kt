package com.dayvatas.runnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.dayvatas.runnables.databinding.ActivityMainBinding
import kotlin.properties.Delegates

private lateinit var binding : ActivityMainBinding
var number = 0
var runnable : Runnable = Runnable {  }
var handler : Handler = Handler()



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun start (view : View){
        number = 0
        runnable = object : Runnable {
            override fun run() {
                number = number + 1
                binding.textView.text = "Time: $number"

                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)

    }
    fun stop(view : View){
        handler.removeCallbacks(runnable)
        number = 0
        binding.textView.text = "Time: $number"
    }
}