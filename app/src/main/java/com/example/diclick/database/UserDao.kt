package com.example.diclick.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Query("DELETE FROM user_table2")
    fun deleteAllUsers()

    @Query("SELECT * FROM user_table2 ORDER BY nilai DESC")
    fun readAllData(): LiveData<List<User>>


    //Hand
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser1(user: User1)

    @Query("DELETE FROM user_hand1")
    fun deleteAllUsers1()

    @Query("SELECT * FROM user_hand1 ORDER BY nilai DESC")
    fun readAllData1(): LiveData<List<User1>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser2(user: User2)

    @Query("DELETE FROM user_hand2")
    fun deleteAllUsers2()

    @Query("SELECT * FROM user_hand2 ORDER BY nilai DESC")
    fun readAllData2(): LiveData<List<User2>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser3(user: User3)

    @Query("DELETE FROM user_hand3")
    fun deleteAllUsers3()

    @Query("SELECT * FROM user_hand3 ORDER BY nilai DESC")
    fun readAllData3(): LiveData<List<User3>>






}