package com.example.xc_m6_java.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "user_table")
public class User implements Serializable {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "full_name")
    public String fullName;

    public User(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}