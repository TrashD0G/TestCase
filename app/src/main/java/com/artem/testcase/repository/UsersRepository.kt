package com.artem.testcase.repository

import androidx.lifecycle.LiveData
import com.artem.testcase.POJO.Data

class UsersRepository(private val usersDao: UsersDao) {




    val readAllData: LiveData<List<Data>> = usersDao.readAllData()


    suspend fun addUser(users: Users){
        usersDao.addUser(users)
    }

    suspend fun updateUsers(users: Users){
        usersDao.updateUsers(users)
    }


    suspend fun deleteAllUsers(){
        usersDao.deleteAllUsers()
    }


}