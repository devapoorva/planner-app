package com.example.plannerapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.plannerapp.dto.ApplicationForm;
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
                "persons TEXT NOT NULL," +
                "destination TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "start_date TEXT UNIQUE NOT NULL," +
                "end_date TEXT UNIQUE NOT NULL)");
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

    public boolean insertApplication(ApplicationForm applicationForm){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",applicationForm.getName());
        contentValues.put("email",applicationForm.getEmail());
        contentValues.put("mobile",applicationForm.getMobileNumber());
        contentValues.put("source",applicationForm.getSource());
        contentValues.put("destination",applicationForm.getDestination());
        contentValues.put("persons",applicationForm.getNumberOfPerson());
        contentValues.put("start_date",applicationForm.getStartDate());
        contentValues.put("end_date",applicationForm.getEndDate());
        long ins=db.insert("applications", null,contentValues);
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

    public List<ApplicationForm> allApplications(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<ApplicationForm> applicationForms = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from applications",null);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                ApplicationForm applicationForm = new ApplicationForm(
                        cursor.getString(cursor.getColumnIndexOrThrow("name")),
                        cursor.getString(cursor.getColumnIndexOrThrow("mobile")),
                        cursor.getString(cursor.getColumnIndexOrThrow("email")),
                        cursor.getString(cursor.getColumnIndexOrThrow("source")),
                        cursor.getString(cursor.getColumnIndexOrThrow("destination")),
                        cursor.getString(cursor.getColumnIndexOrThrow("persons")),
                        cursor.getString(cursor.getColumnIndexOrThrow("start_date")),
                        cursor.getString(cursor.getColumnIndexOrThrow("end_date"))
                );
                applicationForms.add(applicationForm);
                cursor.moveToNext();
            }
        }
        return applicationForms;
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

