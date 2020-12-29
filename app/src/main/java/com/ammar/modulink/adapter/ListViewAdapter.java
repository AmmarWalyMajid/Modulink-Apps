package com.ammar.modulink.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ammar.modulink.R;
import com.ammar.modulink.dataset.Modul;
import com.ammar.modulink.ui.ModulActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    //Variabel
    Context context;
    LayoutInflater inflater;
    List<Modul> DosenList;
    ArrayList<Modul> arrayList;
    private Typeface typeface;


    //contructor
    public ListViewAdapter(Context context, List<Modul> dosenList) {
        this.context = context;
        DosenList = dosenList;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<Modul>();
        this.arrayList.addAll(dosenList);
//        this.typeface=Typeface.createFromAsset(context.getAssets(),"font/ConcertOne-Regular.ttf");
    }

    public class ViewHolder {

        TextView namadosen, infodosen;
        ImageView fotoDosen;
    }

    @Override
    public int getCount() {
        return DosenList.size();
    }

    @Override
    public Object getItem(int position) {
        return DosenList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);

            //inisialisasi view
            holder.namadosen = view.findViewById(R.id.namaDOSEN);
            holder.infodosen = view.findViewById(R.id.dekripsi);
            holder.fotoDosen = view.findViewById(R.id.imageView);

            //Customfont
//            holder.namadosen.setTypeface(typeface);
//            holder.infodosen.setTypeface(typeface);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        //mengetur letak sesuai inisial view
        holder.namadosen.setText(DosenList.get(position).getNama());
        holder.infodosen.setText(DosenList.get(position).getInfo());
        holder.fotoDosen.setImageResource(DosenList.get(position).getFoto());

        //onclickview
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Modul modul=DosenList.get(position);
                Intent sendData=new Intent(context, ModulActivity.class);
                sendData.putExtra("myName",modul.getNama());
                context.startActivity(sendData);
            }
        });


        return view;


    }

    //adapter filter
    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        DosenList.clear();
        if (charText.length() == 0) {
            DosenList.addAll(arrayList);
        } else {
            for (Modul modul : arrayList) {
                if (modul.getNama().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    DosenList.add(modul);
                }
            }
        }notifyDataSetChanged();
    }

}


