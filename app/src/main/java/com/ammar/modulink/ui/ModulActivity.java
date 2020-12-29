package com.ammar.modulink.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ammar.modulink.fragment.BlankFragment;
import com.ammar.modulink.fragment.d3informatika;
import com.ammar.modulink.fragment.d3management;
import com.ammar.modulink.R;

import java.util.ArrayList;


public class ModulActivity extends AppCompatActivity {

    private ArrayList<String> mydata;

    Spinner spinner;
    d3informatika fragmentData;
    d3management fragmentData1;
    BlankFragment blankFragment;

    TextView texttoolbar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_modul);

        fragmentData=new d3informatika();
        fragmentData1=new d3management();
        blankFragment=new BlankFragment();

        toolbar=(Toolbar)findViewById(R.id.toolbardeskripsi);
        setSupportActionBar(toolbar);

        //SETtexttitle toolbar
        texttoolbar=findViewById(R.id.toolbar_text);
        Intent data=getIntent();
        String Deskripsi=data.getStringExtra("myName");
        texttoolbar.setText(Deskripsi);

         spinner=findViewById(R.id.spiner);
         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 switch (position){
                     case 0:
                         setFragment(fragmentData1);
//                         Toast.makeText(DataDosen.this,"Submit berhasil",Toast.LENGTH_SHORT).show();
                         break;
                     case 1:
                         setFragment(blankFragment);
//                         Toast.makeText(DataDosen.this,"Submit berhasil",Toast.LENGTH_SHORT).show();
                         break;
                     case 2:
                         setFragment(blankFragment);
//                         Toast.makeText(DataDosen.this,"Data Kosong",Toast.LENGTH_SHORT).show();
                         break;
                     case 3:
                     setFragment(blankFragment);
//                         Toast.makeText(DataDosen.this,"Data Kosong",Toast.LENGTH_SHORT).show();
                     break;

                 }
             }

             private void setFragment(Fragment fragment) {

                 FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                 fragmentTransaction.replace(R.id.frame_layout,fragment);
                 fragmentTransaction.commit();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

    }

}
