package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class menu2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        var backgo = findViewById<Button>(R.id.backgo)
        backgo.setOnClickListener(){
            startActivity(Intent(this,menu::class.java))
        }

        var menu2 = intent.getStringExtra("menu2")
        var judul = findViewById<TextView>(R.id.judulmenu2)
        var atas = findViewById<ImageView>(R.id.atas)
        var bawah = findViewById<ImageView>(R.id.bawah)

        if (menu2 == "leaderboard") {
            judul.text = "Leader Board"
            atas.setImageResource(R.drawable.logocolor)
            bawah.setImageResource(R.drawable.logohand)

            atas.setOnClickListener() {
                startActivity(Intent(this@menu2, leaderboardColor::class.java))
            }
            bawah.setOnClickListener() {
                startActivity(Intent(this@menu2, leaderboardHand::class.java))
            }
        } else {
            atas.setOnClickListener() {
                var intent = Intent(this@menu2, hint::class.java)
                startActivity(intent)
            }
            bawah.setOnClickListener() {
                var intent = Intent(this@menu2, hint::class.java)
                intent.putExtra("hand", "hand")
                startActivity(intent)
            }
        }
    }
}