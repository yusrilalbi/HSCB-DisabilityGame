package com.example.diclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.diclick.database.UserViewModel

class usernameInput1 : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username_input1)

        var backgo = findViewById<Button>(R.id.backgo)
        backgo.setOnClickListener(){
            startActivity(Intent(this,handLevel::class.java))
        }

        var enter = findViewById<Button>(R.id.enter)
        var username = findViewById<EditText>(R.id.username)
        var delete = findViewById<Button>(R.id.delete)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        enter.setOnClickListener(){
            var userData = username.text.toString()

            if(!userData.isEmpty()){
                var intent = Intent(this@usernameInput1, testHandLevel1::class.java)
                intent.putExtra("userintent",userData)
                startActivity(intent)
            }
        }
        delete.setOnClickListener(){
            mUserViewModel.deleteAllUsers1()
            Toast.makeText(applicationContext, "Successfully Delete!", Toast.LENGTH_LONG).show()
        }

    }
}