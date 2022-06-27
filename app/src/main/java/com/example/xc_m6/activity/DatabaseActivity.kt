package com.example.xc_m6.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.xc_m6.R
import com.example.xc_m6.database.UserRepository
import com.example.xc_m6.databinding.ActivityDatabaseBinding
import com.example.xc_m6.manager.RealmManager
import com.example.xc_m6.model.Post
import com.example.xc_m6.model.User
import java.util.concurrent.Executors

class DatabaseActivity : AppCompatActivity() {

    lateinit var binding: ActivityDatabaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            bRealm.setOnClickListener { realmDatabase() }

            bRoom.setOnClickListener {
                roomDatabase()
            }
        }
    }

    private fun roomDatabase() {
        val userRepository = UserRepository(application)
        val user = User(1,"Flutter")
        userExecutor(userRepository,user)

    }

    private fun userExecutor(repository: UserRepository, user: User) {
        val executor = Executors.newSingleThreadExecutor() // in background
        val handler = Handler(Looper.getMainLooper()) // in UI/Main

        executor.execute {
            repository.saveUser(user)
            var users = repository.getUsers()

            handler.post {
                binding.tvSize.text ="Room DB' users: " + users.toString()
            }
        }


    }

    private fun realmDatabase() {
        var post = Post(2,"Android bootcamp")
        RealmManager.instance!!.savePost(post)

        var posts = RealmManager.instance!!.loadPosts()
        binding.tvSize.text = "Realm DB's size is " + posts
    }
}

/**     SQL(Relational)                 NoSQL(Document)
 *      SQL( JDBC ) & ORM( JPA )
 *      SQL ( Structured Query Language ): The Old Standby
 *      ORM ( Object Relational Mapping ): The Alternative Method
 *
 *      SQL Databases -> Oracle, MySQL, MSQL Server, PostgreSQL
 *      NoSQL Databases -> MongoDB, Redis, Couchbase, DynamoDB
 *
 *              DATABASES IN MOBILE
 *      SQL Databases -> SQLite( SQL ), Room( ORM )
 *      NoSQL Databases -> Realm, Couchbase
 *
 *      !! For quick store-and-read NoSQL is perfect.
 *
 *      App shouldn't depend on storage - storage should depend on app.
 */