package com.abc.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private SharedPrefenceConfig sharedPrefenceConfig;
   private EditText username,userpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefenceConfig=new SharedPrefenceConfig(getApplicationContext());
        username=findViewById(R.id.username);
        userpassword=findViewById(R.id.password);
        if(sharedPrefenceConfig.ReadLoginStatus()){

            startActivity(new Intent(this,SuccessActivity.class));
            sharedPrefenceConfig.WriteLoginStatus(true);
            finish();
        }
    }

    public void UserLogin(View view) {

        String Username=username.getText().toString();
        String Password=userpassword.getText().toString();

        if (Username.equals(getResources().getString(R.string.username))&& Password.equals(getResources().getString(R.string.userpassword))){

            startActivity(new Intent(this,MainActivity.class));
            sharedPrefenceConfig.WriteLoginStatus(true);
            finish();

        }
        else{
            Toast.makeText(this,"Login Failed....Try Again Later...",Toast.LENGTH_SHORT).show();

            username.setText("");
            userpassword.setText("");
        }

    }
}
