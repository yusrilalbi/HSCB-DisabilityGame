package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.diclick.database.User1
import com.example.diclick.database.User3
import com.example.diclick.database.UserViewModel

class testHandLevel3 : AppCompatActivity() {

    var ans = 0
    var stoper = 0
    var userglobal = ""
    var pilgan : MutableList<ImageButton> = ArrayList()
    var konco : MutableList<Button> = ArrayList()
    var gambar = gambar()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_hand_level3)

        pilgan.add(findViewById(R.id.pilgan1))
        pilgan.add(findViewById(R.id.pilgan2))
        pilgan.add(findViewById(R.id.pilgan3))

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
        for (i in 0..2){
            pilgan[i].setOnClickListener(){
                ans += 1
                repeatan()
            }
            // memberi pilgan
            if(ans<10)
                pilgan[i].setImageResource(gambar.handSoal3[ans][i])
        }

        //memberi tombol benar
        pilgan[ans%3].setOnClickListener(){
            ans += 1
            stoper += 1
            repeatan()
        }
        if(ans==10){
            val allData = User3(0,userglobal,stoper*10)
            mUserViewModel.addUser3(allData)
            var intent = Intent(this@testHandLevel3, score::class.java)
            intent.putExtra("hasil","${stoper}")
            intent.putExtra("nama","${userglobal}")
            startActivity(intent)
        }
        if(ans<10)
            soal.setImageResource(gambar.listHand3[ans])

        Log.d("kokalo","${ans}, ${stoper}")
    }
}