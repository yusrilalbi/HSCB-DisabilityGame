package com.example.diclick.database

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Parcelize
@Entity(tableName = "user_hand2")
data class User2(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val userKey: String,
    val nilai: Int
)//: Parcelable
