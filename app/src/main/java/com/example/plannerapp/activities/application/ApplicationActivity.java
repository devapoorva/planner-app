package com.example.plannerapp.activities.application;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plannerapp.R;
import com.example.plannerapp.database.DatabaseHelper;

public class ApplicationActivity extends AppCompatActivity {
    private RecyclerView rcApplications;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        this.rcApplications = findViewById(R.id.rcApplications);
        this.databaseHelper = new DatabaseHelper(this);

        getSupportActionBar().setTitle("App Form Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.rcApplications.setAdapter(new ApplicationAdapter(this.databaseHelper.allApplications()));
        this.rcApplications.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
