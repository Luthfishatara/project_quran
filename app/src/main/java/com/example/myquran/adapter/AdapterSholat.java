package com.example.myquran.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquran.DetailJadwal;
import com.example.myquran.R;
import com.example.myquran.modal.ModalJadwal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AdapterSholat extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    ArrayList<ModalJadwal> modalJadwals;
    View view;

    public AdapterSholat(Context context, ArrayList<ModalJadwal> modalJadwals) {
        this.context = context;
        this.modalJadwals = modalJadwals;
    }

    class MyJadwalSholat extends RecyclerView.ViewHolder {

        TextView kota, idKota;
        CardView coba;

        public MyJadwalSholat(@NonNull View itemView) {
            super(itemView);

            coba = itemView.findViewById(R.id.coba);
            kota = itemView.findViewById(R.id.kota);
            idKota = itemView.findViewById(R.id.idKota);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sholat, parent, false);

        return new MyJadwalSholat(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int i) {

        ((MyJadwalSholat) holder).kota.setText(modalJadwals.get(i).getKota());

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        final String dateku = simpleDateFormat.format(date);

        ((MyJadwalSholat) holder).idKota.setText(modalJadwals.get(i).getIdKota());
        ((MyJadwalSholat) holder).coba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context.getApplicationContext(), DetailJadwal.class);
                intent.putExtra("id", modalJadwals.get(i).getIdKota());
                intent.putExtra("kota", modalJadwals.get(i).getKota());
                intent.putExtra("tanggal", dateku);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modalJadwals.size();
    }
}
