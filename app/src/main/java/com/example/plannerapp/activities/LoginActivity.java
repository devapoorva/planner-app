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

public class LoginActivity extends AppCompatActivity {

    EditText e1,e2; Button b1;
    TextView registerTV;
    DatabaseHelper db; @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login to Planner App");
        db=new DatabaseHelper(this);
        e1=findViewById(R.id.emaillogin);
        e2=findViewById(R.id.passlogin); b1=findViewById(R.id.login);
        registerTV=findViewById(R.id.registertv);
        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener()
        { @Override
        public void onClick(View v) {
            String email=e1.getText().toString();
            String password=e2.getText().toString();
            Boolean Chkemailpass=db.emailpassword(email, password);
            if (Chkemailpass==true) {
                Toast.makeText(getApplicationContext(), "Successfully Logged in",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(LoginActivity.this, MainActivity.class); startActivity(i);
            }
            else {
                Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
            }
        }
        });

    }
}


