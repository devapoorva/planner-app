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
import com.example.plannerapp.util.AppUtil;

public class LoginActivity extends AppCompatActivity {

    EditText e1,e2; Button b1;
    TextView registerTV;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(AppData.getAppData(this).isLogin()){
            startMain();
        }
        setContentView(R.layout.activity_login);
        setTitle("Login to Planner App");
        db=new DatabaseHelper(this);
        e1=findViewById(R.id.emaillogin);
        e2=findViewById(R.id.passlogin);
        b1=findViewById(R.id.login);
        registerTV=findViewById(R.id.registertv);
        registerTV.setOnClickListener(v -> {
            Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        });
        b1.setOnClickListener(v -> {
            String email=e1.getText().toString();
            String password=e2.getText().toString();
            if(email.isEmpty()){
                AppUtil.showToast(LoginActivity.this,"Email is empty");
            }else if(!AppUtil.isValidEmail(email)){
                AppUtil.showToast(LoginActivity.this,"Invalid Email address");
            }else if(password.isEmpty()){
                AppUtil.showToast(LoginActivity.this,"Password should not be empty");
            }else{
                if(db.loginUser(email,password)){
                    AppData.getAppData(LoginActivity.this).setLogin();
                    AppUtil.showToast(LoginActivity.this,"Login Successful");
                    startMain();
                }else{
                    AppUtil.showToast(LoginActivity.this,"Invalid email or password");
                }
            }
        });

    }

    private void startMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}


