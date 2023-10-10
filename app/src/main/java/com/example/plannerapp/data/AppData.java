package com.example.plannerapp.data;

import android.content.Context;
import android.content.SharedPreferences;

public class AppData {
    private final String name = "Planner";
    private final String login = "LOGIN";
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    private static AppData appData = null;

    private AppData(Context context) {
        this.sharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        this.editor = this.sharedPreferences.edit();
    }

    public boolean isLogin(){
        return this.sharedPreferences.getBoolean(login,false);
    }

    public void setLogin(){
        this.editor.putBoolean(login,true);
        this.editor.commit();
    }

    public void logout(){
        this.editor.putBoolean(login,false);
        this.editor.commit();
    }

    public  static synchronized AppData getAppData(Context context){
        if(appData==null){
            appData = new AppData(context);
        }
        return appData;
    }


}
