package com.example.smarthomes

import android.Manifest
import android.content.Context
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler




class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


            Handler().postDelayed({
                val strtAct = Intent(this, MainActivity::class.java)
                startActivity(strtAct)
                this.finish()

            }, 1000)


    }


}
