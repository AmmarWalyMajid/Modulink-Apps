package com.ammar.modulink.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.ammar.modulink.adapter.ListViewAdapter;
import com.ammar.modulink.R;
import com.ammar.modulink.dataset.Modul;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DosenActivity extends AppCompatActivity {

    //Variabel
    CircleImageView fotoprofil;
    ListView listView;
    ListViewAdapter adapter;
    ArrayList<Modul>arrayList = new ArrayList<Modul>();
    String[] NamaDosen;
    String[] InfoDosen;
    int[] fotoDosen;
    private ArrayList<Modul>data;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //activity Toolbar
        toolbar=(Toolbar)findViewById(R.id.toolbardosen);
        toolbar.setTitle("Dosen");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();

        //valuedata
        NamaDosen = new String[]{

                "Abidarin Rosidi, Dr, M.Ma.",
                "Achmad Fauzan, Dr. M.M",
                "Achmad Fauzi, SE, M.M., Dr.",
                "Acihmah Sidauruk, M.Kom",
                "Ade Pujianto, M.Kom",
                "Adi Djayusman, S.Kom., M.Kom",
                "Aditya Maulana Hasymi, S.IP., M.A",
                "Aditya Rizki Yudiantika, ST, M.Eng",
                "Adrian, MT",
                "Dewi Anisa Istiqomah, S.Pd., M.Cs"
        };
        InfoDosen =new String[]{
                "Dosen",
                "Dosen",
                "Dosen",
                "Dosen",
                "Dosen",
                "Dosen",
                "Dosen",
                "Dosen",
                "Dosen",
                "Dosen"

        };
        fotoDosen=new int[]{
                R.drawable.abidinrosidin,
                R.drawable.achmadfauzan,
                R.drawable.achmadfauzi,
                R.drawable.ic_person,
                R.drawable.adepujianto,
                R.drawable.adidjayusman,
                R.drawable.adityamaulana,
                R.drawable.adityariski,
                R.drawable.andrianmt,
                R.drawable.ic_person
        };

        listView=findViewById(R.id.lv_list);

        for ( int position = 0 ;position<NamaDosen.length; position++){
            Modul modul =  new Modul(NamaDosen[position],fotoDosen[position],InfoDosen[position]);
            arrayList.add(modul); }

        adapter = new ListViewAdapter(this,arrayList);
        listView.setAdapter(adapter);}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_main, menu);


        MenuItem searchItem=menu.findItem(R.id.search);
        final SearchView searchView=(SearchView)searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }else {
                    adapter.filter(newText);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menu=item.getItemId();
        if (menu == R.id.menu_profil){

            Intent intentprofil = new Intent(DosenActivity.this,ProfilActivty.class);
            startActivity(intentprofil);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}


