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

import com.example.myquran.DetailAudio;
import com.example.myquran.R;
import com.example.myquran.modal.ModalServer;

import java.util.ArrayList;

public class AdapterAlquran extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    View view;
    ArrayList<ModalServer> modalServers;

    public AdapterAlquran(Context context, ArrayList<ModalServer> modalServers) {
        this.context = context;
        this.modalServers = modalServers;
    }

    class MyAdapterAlquran extends RecyclerView.ViewHolder {

        TextView id, name, Server, rewaya;
        CardView cardView;

        public MyAdapterAlquran(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            Server = itemView.findViewById(R.id.server);
            rewaya = itemView.findViewById(R.id.rewaya);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_audio, parent, false);

        return new MyAdapterAlquran(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int i) {

        ((MyAdapterAlquran) holder).cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), DetailAudio.class);
                intent.putExtra("Server", modalServers.get(i).getServer());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });

        ((MyAdapterAlquran) holder).id.setText(modalServers.get(i).getId());
        ((MyAdapterAlquran) holder).name.setText(modalServers.get(i).getName());
        ((MyAdapterAlquran) holder).Server.setText(modalServers.get(i).getServer());
        ((MyAdapterAlquran) holder).rewaya.setText(modalServers.get(i).getRewaya());

    }

    @Override
    public int getItemCount() {
        return modalServers.size();
    }
}
