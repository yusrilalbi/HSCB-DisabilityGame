package com.example.diclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class hint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)

        var hintus = intent.getStringExtra("hand")
        var mumbo = findViewById<ImageView>(R.id.loksumawe)
        if(hintus=="hand"){
            mumbo.setImageResource(R.drawable.tutorialhand)
        }

    }
}