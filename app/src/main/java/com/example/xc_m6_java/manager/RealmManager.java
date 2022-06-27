package com.example.xc_m6_java.manager;

import com.example.xc_m6_java.model.Post;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmManager {

    public static final String TAG = RealmManager.class.getSimpleName();
    private static RealmManager realmManager;
    private static Realm realm;

    public static RealmManager getInstance() {
        if (realmManager == null) {
            realmManager = new RealmManager();
        }
        return realmManager;
    }

    public RealmManager() {
        realm = Realm.getDefaultInstance();
    }

    public void savePost(Post post) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(post);
        realm.commitTransaction();
    }

    public ArrayList<Post> loadPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        RealmResults<Post> results = realm.where(Post.class).findAll();
        for (Post post : results) {
            posts.add(post);
        }
        return posts;
    }


}
