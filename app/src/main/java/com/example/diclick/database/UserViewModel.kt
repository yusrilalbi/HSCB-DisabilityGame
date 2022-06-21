package com.example.diclick.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    val readAllData1: LiveData<List<User1>>
    val readAllData2: LiveData<List<User2>>
    val readAllData3: LiveData<List<User3>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
        readAllData1 = repository.readAllData1
        readAllData2 = repository.readAllData2
        readAllData3 = repository.readAllData3
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }


    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }

    fun addUser1(user: User1){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser1(user)
        }
    }


    fun deleteAllUsers1(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers1()
        }
    }

    fun addUser2(user: User2){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser2(user)
        }
    }


    fun deleteAllUsers2(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers2()
        }
    }

    fun addUser3(user: User3){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser3(user)
        }
    }


    fun deleteAllUsers3(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers3()
        }
    }



}