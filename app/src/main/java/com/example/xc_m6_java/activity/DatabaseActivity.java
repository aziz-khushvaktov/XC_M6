package com.example.xc_m6_java.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xc_m6_java.database.UserRepository;
import com.example.xc_m6_java.databinding.ActivityDatabaseBinding;
import com.example.xc_m6_java.manager.RealmManager;
import com.example.xc_m6_java.model.Post;
import com.example.xc_m6_java.model.User;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    ActivityDatabaseBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        binding.bRealm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realmDatabase();
            }
        });
        
        binding.bRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomDatabase();
            }
        });
    }

    void roomDatabase() {
        UserRepository repository = new UserRepository(getApplication());
        User user = new User(1, "Kurbanov Xurshidbek");
        //repository.saveUser(user);
        new UserAsyncTask(repository).execute(user);
    }

    class UserAsyncTask extends AsyncTask<User, Void, List<User>> {
        UserRepository repository;

        UserAsyncTask(UserRepository repository) {
            this.repository = repository;
        }

        @Override
        protected List<User> doInBackground(User... users) {
            repository.saveUser(users[0]);
            return repository.getUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            binding.tvSize.setText("Room DB`s users size is " + users);
        }
    }

    private void realmDatabase() {
        Post post = new Post(1, "PDP");
        RealmManager.getInstance().savePost(post);
        List<Post> posts = RealmManager.getInstance().loadPosts();
        binding.tvSize.setText("Realm DB posts: " + posts);
    }
}