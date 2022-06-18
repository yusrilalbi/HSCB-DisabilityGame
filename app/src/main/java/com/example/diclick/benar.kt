package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class benar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benar_salah)

        var soal = findViewById<ImageView>(R.id.check)
        var next = findViewById<Button>(R.id.next)
        var angka = intent.getStringExtra("angka")
        var jenis = intent.getStringExtra("jenis")
        var hasil = intent.getStringExtra("hasil")

        var check = intent.getStringExtra("foto")
        if(check=="salah"){
                soal.setImageResource(R.drawable.salah)
        }
        else {
                soal.setImageResource(R.drawable.benar)
        }
        next.setOnClickListener(){
            var intent = Intent(this@benar, question::class.java)
            intent.putExtra("tambah","${angka!!.toInt()+1}")
            intent.putExtra("hasil", "${hasil}")
            intent.putExtra("jenis",jenis)
            startActivity(intent)
        }
    }
}