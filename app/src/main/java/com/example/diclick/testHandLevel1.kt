package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.diclick.database.User
import com.example.diclick.database.User1
import com.example.diclick.database.UserViewModel

class testHandLevel1 : AppCompatActivity() {

    var ans = 0
    var stoper = 0
    var userglobal = ""
    var pilgan : MutableList<Button> = ArrayList()
    var konco : MutableList<Button> = ArrayList()
    var gambar = gambar()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_hand_level1)
        pilgan.add(findViewById<Button>(R.id.pilgan1))
        pilgan.add(findViewById<Button>(R.id.pilgan2))
        pilgan.add(findViewById<Button>(R.id.pilgan3))
        pilgan.add(findViewById<Button>(R.id.pilgan4))
        pilgan.add(findViewById<Button>(R.id.pilgan5))

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var userintent = intent.getStringExtra("userintent")
        if (userintent != null) {
            userglobal = userintent
        }

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
                pilgan[i].text = gambar.handSoal1[ans][i]
        }

        //memberi tombol benar
        pilgan[ans%5].setOnClickListener(){
            ans += 1
            stoper += 1
            repeatan()
        }
        if(ans==10){
            val allData = User1(0,userglobal,stoper*10)
            mUserViewModel.addUser1(allData)
            var intent = Intent(this@testHandLevel1, score::class.java)
            intent.putExtra("hasil","${stoper}")
            intent.putExtra("nama","${userglobal}")
            startActivity(intent)
        }
        if(ans<10)
            soal.setImageResource(gambar.listHand1[ans])

        Log.d("kokalo","${ans}, ${stoper}")
    }
    fun funBenar(){
        var jenis = intent.getStringExtra("jenis")
        val intent = Intent(this@testHandLevel1, benar::class.java)
        intent.putExtra("foto","benar")
        intent.putExtra("angka","${ans}")
        intent.putExtra("hasil","${stoper}")
        intent.putExtra("jenis",jenis)
        startActivity(intent)
    }
    fun funSalah(){
        var jenis = intent.getStringExtra("jenis")
        val intent = Intent(this@testHandLevel1, benar::class.java)
        intent.putExtra("foto","salah")
        intent.putExtra("angka","${ans}")
        intent.putExtra("hasil","${stoper}")
        intent.putExtra("jenis",jenis)
        startActivity(intent)
    }
}