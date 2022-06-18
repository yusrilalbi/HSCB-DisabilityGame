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

        tesColor.setOnClickListener(){
            var intent = Intent(this@menu, question::class.java)
            intent.putExtra("jenis", "color")
            startActivity(intent)
        }
        tesHand.setOnClickListener(){
            var intent = Intent(this@menu, question::class.java)
            intent.putExtra("jenis", "hand")
            startActivity(intent)
        }


    }
}