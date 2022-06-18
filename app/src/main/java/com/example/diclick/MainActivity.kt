package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var next = findViewById<Button>(R.id.getStarted)

        next.setOnClickListener(){

            startActivity(Intent(this@MainActivity,menu::class.java))

        }


    }
}