package com.example.xc_m6_java.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.xc_m6_java.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long saveUser(User user);

    @Query("SELECT * FROM user_table")
    List<User> getUsers();
}
