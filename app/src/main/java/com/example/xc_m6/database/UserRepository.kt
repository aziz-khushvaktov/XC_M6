package com.example.xc_m6.database

import android.app.Application
import com.example.xc_m6.manager.RoomManager
import com.example.xc_m6.model.User

class UserRepository {

    lateinit var userDao: UserDao

    constructor(application: Application) {
        val db = RoomManager.getDatabase(application)
        userDao = db.userDao()
    }

    fun getUsers(): List<User> {
        return userDao.getUsers()
    }

    fun saveUser(user: User) {
        userDao.saveUser(user)
    }
}