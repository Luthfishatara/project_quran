package com.example.myquran.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.myquran.DetailSurat;
import com.example.myquran.R;
import com.example.myquran.base.Constant;
import com.example.myquran.modal.Modal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    View view;
    ArrayList<Modal> modals;

    public AdapterHome(Context context, ArrayList<Modal> modals) {
        this.context = context;
        this.modals = modals;
    }

    class MyAdapter extends RecyclerView.ViewHolder {

        TextView nomor, nama, asma, arti;
        CardView card;


        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            nomor = itemView.findViewById(R.id.nomor);
            nama = itemView.findViewById(R.id.nama);
            asma = itemView.findViewById(R.id.asma);
            arti = itemView.findViewById(R.id.arti);
            card = itemView.findViewById(R.id.card);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home, parent, false);

        return new MyAdapter(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int i) {

        ((MyAdapter)holder).card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), DetailSurat.class);
                intent.putExtra("nomor", modals.get(i).getNomor());
                intent.putExtra("nama", modals.get(i).getNama());
                intent.putExtra("asma", modals.get(i).getAsma());
                intent.putExtra("arti", modals.get(i).getArti());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });

        ((MyAdapter)holder).nomor.setText(modals.get(i).getNomor());
        ((MyAdapter)holder).nama.setText(modals.get(i).getNama());
        ((MyAdapter)holder).asma.setText(modals.get(i).getAsma());
        ((MyAdapter)holder).arti.setText(modals.get(i).getArti());



    }

    @Override
    public int getItemCount() {
        return modals.size();
    }
}
