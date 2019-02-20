package com.abc.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefenceConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefenceConfig(Context context){

        this.context=context;
        sharedPreferences=context.getSharedPreferences(context.getResources().getString(R.string.LoginPreference),context.MODE_PRIVATE);
    }

    public void WriteLoginStatus(Boolean status){

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.Login_status_Preference),status);
        editor.commit();

    }
    public Boolean ReadLoginStatus(){

        Boolean status=false;
        status=sharedPreferences.getBoolean(context.getResources().getString(R.string.Login_status_Preference),false);
        return status;
    }
}
