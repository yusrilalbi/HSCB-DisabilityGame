package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_hand_level.*

class handLevel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hand_level)

        var backgo = findViewById<Button>(R.id.backgo)
        backgo.setOnClickListener(){
            startActivity(Intent(this,menu::class.java))
        }

        leve1.setOnClickListener(){
            startActivity(Intent(this@handLevel, usernameInput1::class.java))
        }
        leve2.setOnClickListener(){
            startActivity(Intent(this@handLevel, usernameInput2::class.java))
        }

        leve3.setOnClickListener(){
            startActivity(Intent(this@handLevel, usernameInput3::class.java))
        }

    }
}