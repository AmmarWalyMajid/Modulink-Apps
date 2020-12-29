package com.ammar.modulink.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ammar.modulink.adapter.RecViewAdapter;
import com.ammar.modulink.R;

import java.util.ArrayList;

public class d3management extends Fragment {

    private ArrayList<String> dataSet;
    protected Context context;

    public static d3management newInstance(){
        return new d3management();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            String SOME_VALUE_KEY = "someValueToSave";
            int someStateValue = savedInstanceState.getInt(SOME_VALUE_KEY);
        }
    View view=inflater.inflate(R.layout.recylerview_modul,container,false);

        dataSet=new ArrayList<>();
        RecyclerView rvView = (RecyclerView) view.findViewById(R.id.rv_recylerview);
        rvView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RecViewAdapter(dataSet);
        rvView.setAdapter(adapter);
        loadData();


    return view;
    }

    private void loadData() {

        String nama = getActivity().getIntent().getExtras().getString("myName");

        switch (nama) {
            case "Abidarin Rosidi, Dr, M.Ma.":
                break;

            case "Achmad Fauzan, Dr. M.M":
                break;

            case "Acihmah Sidauruk, M.Kom":
                break;

            case "Achmad Fauzi, SE, M.M., Dr.":
                break;

            case "Ade Pujianto, M.Kom":
                break;

            case  "Adi Djayusman, S.Kom., M.Kom":
                break;

            case "Aditya Maulana Hasymi, S.IP., M.A":
                break;

            case  "Aditya Rizki Yudiantika, ST, M.Eng":
                break;

            case  "Adrian, MT":
                break;

            case "Dewi Anisa Istiqomah, S.Pd., M.Cs":

                dataSet.add("Modul: Input Controls");
                dataSet.add("Modul: Activity");
                dataSet.add("Modul: Intent");
                dataSet.add("Modul: Layout View");
                dataSet.add("Modul: Fragment");
                dataSet.add("Modul: Button");
                dataSet.add("Introduce android");
                dataSet.add("Modul: Introduce");
                break;




        }

    }
    }

