package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class question : AppCompatActivity() {

    var ans = 0
    var stoper = 0
    var pilgan : MutableList<Button> = ArrayList()
    var konco : MutableList<Button> = ArrayList()
    var gambar = gambar()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        var tambah = intent.getStringExtra("tambah")
        var hasil = intent.getStringExtra("hasil")

        var soal = findViewById<ImageView>(R.id.soal)
        var header = findViewById<TextView>(R.id.judul)

        pilgan.add(findViewById<Button>(R.id.pilgan1))
        pilgan.add(findViewById<Button>(R.id.pilgan2))
        pilgan.add(findViewById<Button>(R.id.pilgan3))
        pilgan.add(findViewById<Button>(R.id.pilgan4))

        if (tambah != null){
            ans = tambah.toInt()
        }
        else{
            ans = 0
            stoper = 0
            hasil = "0"
        }
        for (i in 0..3){
            pilgan[i].setOnClickListener(){
                if (hasil != null) {
                    stoper = hasil.toInt()
                }
                funSalah()
            }
            pilgan[i].text = gambar.pilgan[i]
        }
        pilgan[ans%4].setOnClickListener(){

            if (hasil != null) {
                stoper = hasil.toInt() + 1
            }
            funBenar()

        }
        var jenis = intent.getStringExtra("jenis")
        if(jenis=="color"){
            header.text = "Color Blind Test"
            soal.setImageResource(gambar.listColor[ans%2])

        }
        else{
            header.text = "Hand Sign Test"
            soal.setImageResource(gambar.listHand[ans%2])
        }

        if(ans==10){
            var intent = Intent(this@question, score::class.java)
            intent.putExtra("hasil","${hasil}")
            startActivity(intent)
        }

        Log.d("kokalo","${ans}, ${stoper}, ${hasil}")

    }
    fun funBenar(){
        var jenis = intent.getStringExtra("jenis")
        val intent = Intent(this@question, benar::class.java)
        intent.putExtra("foto","benar")
        intent.putExtra("angka","${ans}")
        intent.putExtra("hasil","${stoper}")
        intent.putExtra("jenis",jenis)
        startActivity(intent)
    }
    fun funSalah(){
        var jenis = intent.getStringExtra("jenis")
        val intent = Intent(this@question, benar::class.java)
        intent.putExtra("foto","salah")
        intent.putExtra("angka","${ans}")
        intent.putExtra("hasil","${stoper}")
        intent.putExtra("jenis",jenis)
        startActivity(intent)
    }
}