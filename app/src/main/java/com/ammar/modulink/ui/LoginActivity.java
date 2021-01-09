package com.ammar.modulink.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ammar.modulink.Preferences.SharedPrefences;
import com.ammar.modulink.R;

public class LoginActivity extends AppCompatActivity {

    private EditText nim,password;
    private SharedPrefences sharedPrefences;
    private SharedPreferences.Editor editor;
    private final Handler handler = new Handler();
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        nim=findViewById(R.id.et_nim);
        password=findViewById(R.id.et_password);
        sharedPrefences = new SharedPrefences(this);
        progressBar = findViewById(R.id.progresbarlogin);

        ImageButton login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    void login(){

        final String Nim = nim.getText().toString();
        final String Password = password.getText().toString();

        progressBar.setVisibility(View.VISIBLE);

        if (Nim.isEmpty() || Password.isEmpty()){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this, "Wrong..", Toast.LENGTH_SHORT).show();
        }else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    String spUsername = sharedPrefences.getUsername();
                    String spPassword = sharedPrefences.getPassword();

                    Log.d("username","user"+Nim);
                    Log.d("password","pass"+Password);

                    if (Nim.equals(spUsername) && Password.equals(spPassword)){
                        Intent i = new Intent(LoginActivity.this, DosenActivity.class);
                        sharedPrefences.saveIsLogin(true);
                        finishAffinity();
                        startActivity(i);
                    }else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, "Failed to login,check email and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }, 3000L);
        }
    }
}
