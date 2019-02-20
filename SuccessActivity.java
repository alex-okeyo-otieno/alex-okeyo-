package com.abc.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {
    SharedPrefenceConfig sharedPrefenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
    }


    public void LogOut(View view) {
        sharedPrefenceConfig.WriteLoginStatus(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
}
