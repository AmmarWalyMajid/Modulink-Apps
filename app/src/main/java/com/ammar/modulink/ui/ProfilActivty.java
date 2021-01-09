package com.ammar.modulink.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ammar.modulink.Preferences.SharedPrefences;
import com.ammar.modulink.R;

public class ProfilActivty extends AppCompatActivity implements View.OnClickListener{

    private SharedPrefences sharedPrefences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        sharedPrefences = new SharedPrefences(this);

        ImageButton back=findViewById(R.id.backhome);
        back.setOnClickListener(this);

        TextView logout =findViewById(R.id.logout);
        logout.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.logout:{

                AlertDialog.Builder logout=new AlertDialog.Builder(ProfilActivty.this);
                logout.setMessage("Do you Want to EXIT???")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intentlogout=new Intent(ProfilActivty.this,LoginActivity.class);
                                sharedPrefences.saveIsLogin(false);
                                finishAffinity();
                                startActivity(intentlogout);
                                Toast.makeText(ProfilActivty.this,"LOGOUT",Toast.LENGTH_SHORT).show();
                            }
                        });

                logout.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });AlertDialog dialog=logout.create();
                dialog.show();
                break;
            }
            case R.id.backhome:{
                Intent back=new Intent(ProfilActivty.this, DosenActivity.class);
                startActivity(back);
                break;

            }
        }
    }
}



