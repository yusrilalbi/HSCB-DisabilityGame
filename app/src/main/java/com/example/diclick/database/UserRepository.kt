package com.example.diclick.database

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()
    val readAllData1: LiveData<List<User1>> = userDao.readAllData1()
    val readAllData2: LiveData<List<User2>> = userDao.readAllData2()
    val readAllData3: LiveData<List<User3>> = userDao.readAllData3()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

    //Hand
    suspend fun addUser1(user: User1){
        userDao.addUser1(user)
    }

    suspend fun deleteAllUsers1(){
        userDao.deleteAllUsers1()
    }

    suspend fun addUser2(user: User2){
        userDao.addUser2(user)
    }

    suspend fun deleteAllUsers2(){
        userDao.deleteAllUsers2()
    }

    suspend fun addUser3(user: User3){
        userDao.addUser3(user)
    }

    suspend fun deleteAllUsers3(){
        userDao.deleteAllUsers3()
    }

}