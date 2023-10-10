package com.example.plannerapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.plannerapp.dto.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public DatabaseHelper(@Nullable Context context)
    {
        super(context, "planner_app.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table users(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "password TEXT NOT NULL )");
        db.execSQL("Create table applications(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "mobile TEXT NOT NULL UNIQUE," +
                "source TEXT NOT NULL," +
                "destination TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "startDate TEXT UNIQUE NOT NULL," +
                "endDate TEXT UNIQUE NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists applications");
    }
    public boolean insertUser(User user)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",user.getEmail());
        contentValues.put("name",user.getName());
        contentValues.put("password",user.getPassword());
        long ins=db.insert("users", null,contentValues);
        return ins != -1;
    }

    public List<User> allUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> users = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from users",null);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                User user = new User(
                        cursor.getString(cursor.getColumnIndexOrThrow("email")),
                        cursor.getString(cursor.getColumnIndexOrThrow("password")),
                        cursor.getString(cursor.getColumnIndexOrThrow("name"))
                );
                users.add(user);
                cursor.moveToNext();
            }
        }
        return users;
    }

    public Boolean isUserExist(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from users where email=?",new String[]{email});
        return cursor.getCount() > 0;
    }

    public Boolean loginUser(String email, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from users where email=? and password=?",new String[]{email, password});
        return cursor.getCount() > 0;
    }
}

