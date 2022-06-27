package com.example.xc_m6.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user_table")
open class User(@PrimaryKey val id: Int, @ColumnInfo(name = "fullName") val fullName: String): Serializable {

    override fun toString(): String {
        return  "User{ " + "id = " + id + ", fullName = '" + fullName + '\'' + " }"

    }
}