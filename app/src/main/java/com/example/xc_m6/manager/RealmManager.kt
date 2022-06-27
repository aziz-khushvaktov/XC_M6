package com.example.xc_m6.manager

import com.example.xc_m6.model.Post
import io.realm.Realm
import io.realm.RealmResults

class RealmManager {

    val TAG = RealmManager::class.java.simpleName

    companion object {
        private var realmManager: RealmManager? = null
        private  val realm: Realm

        val instance: RealmManager?
                get() {
                    if (realmManager == null) {
                        realmManager = RealmManager()
                    }
                    return realmManager
                }

        init {
            realm = Realm.getDefaultInstance()
        }
    }
    fun savePost(post: Post) {
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(post) // If post that has same ID realm won't add it again. It just will update it.
        realm.commitTransaction()
    }

    fun loadPosts(): ArrayList<Post> {
        var posts: ArrayList<Post> = ArrayList()
        var results: RealmResults<Post> = realm.where(Post::class.java).findAll()
        for (post in results) {
            posts.add(post)
        }
        return posts
    }
}