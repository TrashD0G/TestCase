package com.artem.testcase.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.artem.testcase.POJO.Data

@Dao
interface UsersDao {

    @Query("SELECT * FROM users_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Data>>

    @Query("Delete  FROM users_table")
    suspend fun deleteAllUsers()


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(users: Users)

    @Update
    suspend fun updateUsers(users: Users)



}