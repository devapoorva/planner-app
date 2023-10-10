package com.example.plannerapp.activities.users;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plannerapp.R;
import com.example.plannerapp.database.DatabaseHelper;
import com.example.plannerapp.dto.User;

import java.util.List;

public class UserActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private RecyclerView userRecycleView;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        databaseHelper = new DatabaseHelper(this);

        getSupportActionBar().setTitle("App Users");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        List<User> users = databaseHelper.allUsers();
        userRecycleView = findViewById(R.id.rcUsers);
        userAdapter = new UserAdapter(users);
        userRecycleView.setAdapter(userAdapter);
        userRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
