package com.example.plannerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.plannerapp.R;

public class FormActivity extends AppCompatActivity {

    EditText name,mobileno,email,source,destination,noofperson,edtdob; Button btnsubmit;
    DatePicker dtdob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        /*name=(EditText)findViewById(R.id.name);
        mobileno=(EditText)findViewById(R.id.mobileno);
        email=(EditText)findViewById(R.id.email);
        source=(EditText)findViewById(R.id.source);
        destination=(EditText)findViewById(R.id.destination); noofperson=(EditText)findViewById(R.id.noofperson); edtdob=(EditText)findViewById(R.id.edtdob); btnsubmit=(Button)findViewById(R.id.btnsubmit); dtdob=(DatePicker)findViewById(R.id.dtdob);*/
    }
    public void displaydate(View v)
    {
        if (dtdob.getVisibility() == View.INVISIBLE)
        {
            dtdob.setVisibility(View.VISIBLE);
        }
        else if (
                dtdob.getVisibility() == View.VISIBLE)
        {
            int dt = dtdob.getDayOfMonth();
            int dt1 = dtdob.getMonth() + 1; int dt2 = dtdob.getYear();
            edtdob.setText(dt + "/" + dt1 + "/" + dt2);
            dtdob.setVisibility(View.INVISIBLE);
        }
    }

    public void form(View v){
        Intent in = new Intent(this,FormActivity.class); startActivity(in);
    }

    public void submit(View v)
    {

        if(name.getText().toString().isEmpty()||email.getText().toString().isEmpty()||mobileno.getText().toString().isEmpty()
                ||source.getText().toString().isEmpty()||destination.getText().toString().isEmpty()||edtdob.getText().toString().isEmpty()){
            Toast.makeText(this,"All fields are mandatory",Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(this,"Thank You Our Executive will get back to you",Toast.LENGTH_SHORT).show();
            Intent in=new Intent(this,MainActivity.class);
            startActivity(in);
        }
    }
}