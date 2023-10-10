package com.example.plannerapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.plannerapp.R;
import com.example.plannerapp.activities.banglore.BengaluruHotelActivity;
import com.example.plannerapp.activities.banglore.BengaluruPlaceActivity;
import com.example.plannerapp.activities.banglore.BengaluruDiningActivity;

public class BengaluruActivity extends AppCompatActivity {
    CardView cardHotel,cardPlaces,cardDining;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banglore);
        getSupportActionBar().setTitle("Bengaluru");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initialize();
    }

    public void initialize(){
        cardHotel = findViewById(R.id.cardHotel);
        cardPlaces = findViewById(R.id.cardLocation);
        cardDining = findViewById(R.id.cardDining);
        cardHotel.setOnClickListener(view-> startActivity(new Intent(this, BengaluruHotelActivity.class)));
        cardPlaces.setOnClickListener(view-> startActivity(new Intent(this, BengaluruPlaceActivity.class)));
        cardDining.setOnClickListener(view-> startActivity(new Intent(this, BengaluruDiningActivity.class)));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void form(View view) {
        startActivity(new Intent(this, FormActivity.class));
    }
}
