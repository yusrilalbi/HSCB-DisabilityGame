package com.example.diclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.diclick.database.UserViewModel
import kotlinx.android.synthetic.main.activity_leaderboard_hand.*

class leaderboardHand : AppCompatActivity() {

    var nilai = gambar()
    var player : MutableList<Button> = ArrayList()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard_hand)

        for (i in 0..11){
            player.add(findViewById<Button>(nilai.listplayercolor[i]))
        }

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData1.observe(
            this,
            Observer {
                if(!it.isEmpty()){
                    for (i in it.indices){
                        player[i].text = "${it[i].userKey} , ${it[i].nilai}"
                        if(i==11){
                            break
                        }
                    }
                }
            }
        )
        one.setOnClickListener(){
            for (i in 0..11){
                player[i].text = ""
            }
            mUserViewModel.readAllData1.observe(
                this,
                Observer {
                    if(!it.isEmpty()){
                        for (i in it.indices){
                            player[i].text = "${it[i].userKey} , ${it[i].nilai}"
                            if(i==11){
                                break
                            }
                        }
                    }
                }
            )
        }
        two.setOnClickListener(){
            for (i in 0..11){
                player[i].text = ""
            }
            Log.d("rhuware", "masuk")
            mUserViewModel.readAllData2.observe(
                this,
                Observer {
                    if(!it.isEmpty()){
                        for (i in it.indices){
                            player[i].text = "${it[i].userKey} , ${it[i].nilai}"
                            if(i==11){
                                break
                            }
                        }
                    }
                }
            )
        }
        three.setOnClickListener(){
            for (i in 0..11){
                player[i].text = ""
            }
            mUserViewModel.readAllData3.observe(
                this,
                Observer {
                    if(!it.isEmpty()){
                        for (i in it.indices){
                            player[i].text = "${it[i].userKey} , ${it[i].nilai}"
                            if(i==11){
                                break
                            }
                        }
                    }
                }
            )
        }
    }
}