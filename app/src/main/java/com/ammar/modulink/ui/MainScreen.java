package com.ammar.modulink.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.ammar.modulink.Preferences.SharedPrefences;
import com.ammar.modulink.R;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        final SharedPrefences sharedPrefences = new SharedPrefences(this);


        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPrefences.getIsLogin()){
                    Intent i = new Intent(MainScreen.this, DosenActivity.class);
                    finishAffinity();
                    startActivity(i);
                }else{
                    Intent i = new Intent(MainScreen.this, LoginActivity.class);
                    finishAffinity();
                    startActivity(i);
                }
            }
        },3000L);

    }
}
