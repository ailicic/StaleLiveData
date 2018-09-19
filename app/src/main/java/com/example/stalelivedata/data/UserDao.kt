package com.example.stalelivedata.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.stalelivedata.data.User

@Dao
interface UserDao {
    @Insert
    fun insert(obj: User): Long

    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT Count(*) FROM users")
    fun getCount(): Int

    @Query("DELETE FROM users")
    fun deleteAll()
}