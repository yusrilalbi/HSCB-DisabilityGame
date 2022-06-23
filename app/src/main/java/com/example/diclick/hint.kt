package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class hint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)
        var backgo = findViewById<Button>(R.id.backgo)
        backgo.setOnClickListener(){
            startActivity(Intent(this,menu::class.java))
        }
        var hintus = intent.getStringExtra("hand")
        var mumbo = findViewById<ImageView>(R.id.loksumawe)
        if(hintus=="hand"){
            mumbo.setImageResource(R.drawable.tutorialhand)
        }

    }
}