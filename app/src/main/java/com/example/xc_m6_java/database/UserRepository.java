package com.example.xc_m6_java.database;

import android.app.Application;

import com.example.xc_m6_java.manager.RoomManager;
import com.example.xc_m6_java.model.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Application application) {
        RoomManager db = RoomManager.getDatabase(application);
        userDao = db.usersDao();
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
