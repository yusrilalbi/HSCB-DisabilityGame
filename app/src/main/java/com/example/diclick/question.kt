package com.example.diclick

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.diclick.database.User
import com.example.diclick.database.UserViewModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class question : AppCompatActivity() {

    var ans = 0
    var stoper = 0
    var userglobal = ""
    var time = ""
    var pilgan : MutableList<Button> = ArrayList()
    var konco : MutableList<Button> = ArrayList()
    var gambar = gambar()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var userintent = intent.getStringExtra("userintent")
        if (userintent != null) {
            userglobal = userintent
        }

        pilgan.add(findViewById<Button>(R.id.pilgan1))
        pilgan.add(findViewById<Button>(R.id.pilgan2))
        pilgan.add(findViewById<Button>(R.id.pilgan3))
        pilgan.add(findViewById<Button>(R.id.pilgan4))
        pilgan.add(findViewById<Button>(R.id.pilgan5))

        var header = findViewById<TextView>(R.id.judul)
        header.text = "Color Blind Test"

        repeatan()

    }
    fun repeatan(){
        var soal = findViewById<ImageView>(R.id.soal)
        //memberi tombol salah
        for (i in 0..4){
            pilgan[i].setOnClickListener(){
                ans += 1
                repeatan()
            }
            // memberi pilgan
            if(ans<10)
                pilgan[i].text = gambar.colorSoal[ans][i]
        }

        //memberi tombol benar
        pilgan[ans%5].setOnClickListener(){
            ans += 1
            stoper += 1
            repeatan()
        }
        if(ans==10){
            var intent = Intent(this@question, score::class.java)
            intent.putExtra("hasil","${stoper}")
            intent.putExtra("nama","${userglobal}")

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss")
                time = current.format(formatter)
            }
            else {
                var date = Date()
                val formatter = SimpleDateFormat("MMM dd yyyy HH:mma")
                time = formatter.format(date)
            }

            userglobal = "${userglobal}\n${time}"
            val allData = User(0,userglobal,stoper*10)
            mUserViewModel.addUser(allData)

            startActivity(intent)
        }
        if(ans<10)
            soal.setImageResource(gambar.listColor[ans])

        Log.d("kokalo","${ans}, ${stoper}")
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