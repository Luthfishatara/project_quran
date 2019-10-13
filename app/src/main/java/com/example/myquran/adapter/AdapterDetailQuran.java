package com.example.myquran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquran.R;
import com.example.myquran.modal.ModalDetailQuran;

import java.util.ArrayList;

public class AdapterDetailQuran extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ModalDetailQuran> modalDetailQurans;
    Context context;

    public AdapterDetailQuran(ArrayList<ModalDetailQuran> modalDetailQurans, Context context) {
        this.modalDetailQurans = modalDetailQurans;
        this.context = context;
    }

    class MyAdapterQuran extends RecyclerView.ViewHolder{

        private TextView nomor, name, arti;

        public MyAdapterQuran(@NonNull View itemView) {
            super(itemView);

            nomor = itemView.findViewById(R.id.nomor);
            name = itemView.findViewById(R.id.ar);
            arti = itemView.findViewById(R.id.id);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_surat, null);

        return new MyAdapterQuran(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        ((MyAdapterQuran) holder).nomor.setText(modalDetailQurans.get(i).getNomor());
        ((MyAdapterQuran)holder).name.setText(modalDetailQurans.get(i).getName());
        ((MyAdapterQuran)holder).arti.setText(modalDetailQurans.get(i).getArti());

    }

    @Override
    public int getItemCount() {
        return modalDetailQurans.size();
    }
}
