package com.ammar.modulink.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.ammar.modulink.R;
import com.ammar.modulink.ui.ModulView;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    private ArrayList<String> rvData;
    private static Context context;

    public RecViewAdapter(ArrayList<String> inputData) {
        rvData = inputData;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView temu;
        public TextView nama_materi;
        public TextView tanggal_upload;
        Button open;

        public ViewHolder(View v) {
            super(v);
            temu = (TextView) v.findViewById(R.id.pertemuan);
            nama_materi = (TextView) v.findViewById(R.id.tv_nama_materi);
            tanggal_upload = (TextView) v.findViewById(R.id.tv_tanggal);

            open=(Button) v.findViewById(R.id.btn_openmodul);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modul, parent, false);
        context=parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        final String name = rvData.get(position);

            holder.temu.setText("0"+position);
            holder.nama_materi.setText(rvData.get(position));
            holder.tanggal_upload.setText("2020-06-"+position);

        holder.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ModulView.class);
                context.startActivity(intent);

                Toast.makeText(holder.itemView.getContext(),
                        "membuka dokumen "+rvData.get(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }

}

