package com.example.xc_m6.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.xc_m6.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: User)

    @Query("SELECT * FROM user_table")
    fun getUsers(): List<User>
}