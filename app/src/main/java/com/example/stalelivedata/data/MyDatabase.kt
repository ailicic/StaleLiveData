package com.example.stalelivedata.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
        entities = [User::class],
        version = 2
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var myDb: MyDatabase? = null
        fun getInstance(context: Context): MyDatabase =
            myDb ?: synchronized(this) {
                myDb ?: buildDatabase(context).also{ myDb = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java, "my_db")
                .allowMainThreadQueries()
                .build()
    }
}

