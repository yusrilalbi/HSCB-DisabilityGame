package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        var hasil = intent.getStringExtra("hasil")
        var nama = intent.getStringExtra("nama")
        var score = findViewById<TextView>(R.id.nilai)
        var namaewa = findViewById<TextView>(R.id.namaewa)
        var kembali = findViewById<Button>(R.id.kembali)

        kembali.setOnClickListener(){
            startActivity(Intent(this@score, menu::class.java))
        }

        if (hasil != null) {
            score.text = (hasil.toInt()*10).toString()
            namaewa.text = nama

        }



    }
}