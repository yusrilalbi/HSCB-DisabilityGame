package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.diclick.database.UserViewModel
import com.example.diclick.gambar
import kotlinx.android.synthetic.main.activity_leaderboard_color.*
import kotlinx.android.synthetic.main.activity_question.*

class leaderboardColor : AppCompatActivity() {

    var nilai = gambar()
    var player : MutableList<Button> = ArrayList()
    var rank : MutableList<Button> = ArrayList()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard_color)

        var backgo = findViewById<Button>(R.id.backgo)
        backgo.setOnClickListener(){
            var intent = Intent(this,menu2::class.java)
            intent.putExtra("jenis", "color")
            intent.putExtra("menu2", "leaderboard")
            startActivity(intent)
        }

        for (i in 0..11){
            player.add(findViewById<Button>(nilai.listplayer[i]))
            rank.add(findViewById(nilai.listrank[i]))
            player[i].text = ""
            rank[i].text = ""
        }
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(
            this,
            Observer {
                if(!it.isEmpty()){
                    for (i in it.indices){
                        player.add(findViewById<Button>(nilai.listplayer[i]))
                        rank.add(findViewById(nilai.listrank[i]))
                        player[i].text = "${it[i].userKey}"
                        rank[i].text = "${it[i].nilai}"
                        if(i==11){
                            break
                        }
                    }

                }
            }
        )

    }
}