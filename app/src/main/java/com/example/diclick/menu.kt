package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var tesColor = findViewById<ImageView>(R.id.tesColor)
        var tesHand = findViewById<ImageView>(R.id.tesHand)
        var exHint = findViewById<ImageView>(R.id.exHint)
        var exLeader = findViewById<ImageView>(R.id.exLeader)

        tesColor.setOnClickListener(){
            var intent = Intent(this@menu, usernameInput::class.java)
            startActivity(intent)
        }
        tesHand.setOnClickListener(){
            var intent = Intent(this@menu, handLevel::class.java)
            startActivity(intent)
        }
        exHint.setOnClickListener(){
            var intent = Intent(this@menu, menu2::class.java)
            startActivity(intent)
        }
        exLeader.setOnClickListener(){
            var intent = Intent(this@menu, menu2::class.java)
            intent.putExtra("jenis", "color")
            intent.putExtra("menu2", "leaderboard")
            startActivity(intent)
        }

    }
}