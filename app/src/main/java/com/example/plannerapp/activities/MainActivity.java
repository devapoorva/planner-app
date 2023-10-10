package com.example.plannerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.plannerapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bang(View v){
        Intent in = new Intent(this, BengaluruActivity.class);
        startActivity(in);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==R.id.aboutus)
        {
            Intent in=new Intent(this,AboutActivity.class);
            startActivity(in);
        }
        if(id==R.id.contactus)
        {
            Intent intent=new Intent(this,ContactActivity.class);
            startActivity(intent);
        }
        if(id==R.id.location){
            Intent intent1=new Intent(this, LocationActivity.class);
            startActivity(intent1);
        }
        return true;
    }
    public boolean onCreateOptionsMenu(Menu m)
    { MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.app_menu,m);
        return true;
    }

    public void ker(View view) {
        Intent in = new Intent(this, BengaluruActivity.class);
        startActivity(in);
    }

    public void mum(View view) {
        Intent in = new Intent(this, BengaluruActivity.class);
        startActivity(in);
    }
}