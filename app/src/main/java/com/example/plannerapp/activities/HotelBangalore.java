package com.example.plannerapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.plannerapp.R;

public class HotelBangalore extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_banglore);
    }

    public void form(View v){
        Intent in = new Intent(this,FormActivity.class); startActivity(in);
    }

}
