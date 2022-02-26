package com.example.practica1_giovannivalencia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //llamando la función startTimer
        startTimer()
    }

    //función que define el tiempo de mi splash
    fun startTimer(){
        //caunto tiempo se tardará mi timer
        object : CountDownTimer(3000, 1000){

            //al momento de cada intervalo
            override fun onTick(millisUntilFinished: Long) {

            }

            //cuando termine el intervalo
            override fun onFinish() {

                //pasando el tiempo que nos transfiera a mi Principal Activity
                val intent = Intent(applicationContext, PrincipalActivity::class.java).apply{}
                startActivity(intent)
                finish()
            }

        }.start()
    }
}