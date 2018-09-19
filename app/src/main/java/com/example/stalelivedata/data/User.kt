package com.example.stalelivedata.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    val name: String
) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}