package com.ammar.modulink.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ammar.modulink.Preferences.SharedPrefences;
import com.ammar.modulink.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SharedPrefences sharedPrefences = new SharedPrefences(this);

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPrefences.getIsLogin()){
                    Intent i = new Intent(SplashActivity.this, DosenActivity.class);
                    finishAffinity();
                    startActivity(i);
                }else{
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    finishAffinity();
                    startActivity(i);
                }
            }
        },2000L);

    }
}
