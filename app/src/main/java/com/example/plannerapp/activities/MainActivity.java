package com.example.plannerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.plannerapp.R;
import com.example.plannerapp.activities.application.ApplicationActivity;
import com.example.plannerapp.activities.users.UserActivity;
import com.example.plannerapp.data.AppData;
import com.example.plannerapp.util.AppUtil;

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
        if(id==R.id.users){
            startActivity(new Intent(this, UserActivity.class));
        }
        if(id==R.id.application){
            startActivity(new Intent(this, ApplicationActivity.class));
        }
        if(id==R.id.logout){
            AppData.getAppData(this).logout();
            AppUtil.showToast(getApplicationContext(),"Logout Successful");
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        return true;
    }
    public boolean onCreateOptionsMenu(Menu m)
    {
        MenuInflater inf=getMenuInflater();
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