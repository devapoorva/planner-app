package com.example.plannerapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plannerapp.R;
import com.example.plannerapp.data.AppData;
import com.example.plannerapp.database.DatabaseHelper;
import com.example.plannerapp.dto.User;
import com.example.plannerapp.util.AppUtil;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText edtName, edtEmail, edtPassword;
    Button btnRegister;
    TextView tvLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register to Planner App");
        db = new DatabaseHelper(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edtName = findViewById(R.id.regEdtName);
        edtEmail = findViewById(R.id.regEdtEmail);
        edtPassword = findViewById(R.id.regEdtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        this.tvLogin.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        this.btnRegister.setOnClickListener(view -> {
            String email = this.edtEmail.getText().toString().trim();
            String name = this.edtName.getText().toString().trim();
            String password = this.edtPassword.getText().toString().trim();
            if (name.isEmpty()) {
                AppUtil.showToast(this, "Name should be not empty");
            } else if (email.isEmpty()) {
                AppUtil.showToast(this, "Email should be not empty");
            } else if (!AppUtil.isValidEmail(email)) {
                AppUtil.showToast(this, "Invalid Email address");
            } else if (password.isEmpty()) {
                AppUtil.showToast(this, "Password should not be empty");
            } else {
                if (db.isUserExist(email)) {
                    AppUtil.showToast(this, "User already exist");
                } else {
                    User user = new User(email,password,name);
                    if(db.insertUser(user)){
                        AppUtil.showToast(this, "User registered successfully");
                        startActivity(new Intent(this,LoginActivity.class));
                    }else{
                        AppUtil.showToast(this,"User not registered");
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}

