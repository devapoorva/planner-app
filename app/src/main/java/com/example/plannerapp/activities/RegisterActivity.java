package com.example.plannerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plannerapp.R;
import com.example.plannerapp.database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity
{
    DatabaseHelper db;
    EditText e1, e2, e3; Button b1; TextView loginTV; @Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    db=new DatabaseHelper(this);
    e1=findViewById(R.id.email);
    e2=findViewById(R.id.pass);
    e3=findViewById(R.id.cpass);
    b1=findViewById(R.id.register);
    loginTV=findViewById(R.id.logintv);
    loginTV.setOnClickListener(new View.OnClickListener() { @Override
    public void onClick(View v) {
        Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }
    });
    b1.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String s1=e1.getText().toString();
            String s2=e2.getText().toString();
            String s3=e3.getText().toString();
            if (s1.equals("")||s2.equals("")||s3.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            }
            else {
                if (s2.equals(s3)) {
                    Boolean chkemail=db.chkemail(s1);
                    if (chkemail==true)
                    {
                        Boolean insert=db.insert(s1, s2);
                        if (insert==true)
                        {
                            Toast.makeText(getApplicationContext(),"Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(i);
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Email Already exists", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } }
        } });
} }

