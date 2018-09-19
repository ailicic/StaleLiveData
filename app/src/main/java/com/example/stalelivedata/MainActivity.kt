package com.example.stalelivedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.stalelivedata.data.MyDatabase
import com.example.stalelivedata.data.User
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindClickListeners()
    }

    private fun bindClickListeners() {
        val userDao = MyDatabase.getInstance(applicationContext).userDao()
        val usersLiveData = userDao.getAll()

        val observer = Observer<List<User>> { userList ->
            appendToLog("Count=${userList.count()}")
            userList.forEach {
                val msg = "$it (id=${it.id})"
                appendToLog("$it (id=${it.id})")
            }
        }

        observeButton.setOnClickListener {
            appendToLog("OBSERVE")
            usersLiveData.observe(this, observer)
        }

        unobserveButton.setOnClickListener {
            appendToLog("UNOBSERVE")
            usersLiveData.removeObserver(observer)
        }

        addButton.setOnClickListener {
            appendToLog("ADD")
            val userCount = userDao.getCount()
            userDao.insert(User("User ${userCount + 1}"))
        }

        deleteButton.setOnClickListener {
            appendToLog("DELETE")
            userDao.deleteAll()
        }
    }

    private fun appendToLog(msg: String) {
        val sb = StringBuilder(logTextView.text)
        sb.append("\n$msg")
        logTextView.text = sb.toString()

        Log.d("TAG", sb.toString())
    }
}
