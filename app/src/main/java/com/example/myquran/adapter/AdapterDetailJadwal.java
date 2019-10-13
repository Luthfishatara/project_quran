package com.example.myquran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquran.R;
import com.example.myquran.modal.ModalDetailJadwal;
import com.example.myquran.modal.ModalJadwal;

import java.util.ArrayList;

public class AdapterDetailJadwal extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ModalDetailJadwal> modalDetailJadwals;
    ArrayList<ModalJadwal> modalJadwals;
    Context context;

    public AdapterDetailJadwal(ArrayList<ModalDetailJadwal> modalDetailJadwals, Context context) {
        this.modalDetailJadwals = modalDetailJadwals;
        this.context = context;
    }

    class MyAdapterDetailJadwal extends RecyclerView.ViewHolder {

        private TextView  tanggal, imsyak, subuh, terbit, dhuha, dzuhur, ashar, maghrib, isya;

        public MyAdapterDetailJadwal(@NonNull View itemView) {
            super(itemView);

            tanggal = itemView.findViewById(R.id.tanggal);
            imsyak = itemView.findViewById(R.id.imsyak);
            subuh = itemView.findViewById(R.id.subuh);
            terbit = itemView.findViewById(R.id.terbit);
            dhuha = itemView.findViewById(R.id.dhuha);
            dzuhur = itemView.findViewById(R.id.dzuhur);
            ashar = itemView.findViewById(R.id.ashar);
            maghrib = itemView.findViewById(R.id.maghrib);
            isya = itemView.findViewById(R.id.isya);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_jadwal, null);

        return new MyAdapterDetailJadwal(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        ((MyAdapterDetailJadwal) holder).tanggal.setText(modalDetailJadwals.get(i).getTanggal());
        ((MyAdapterDetailJadwal) holder).imsyak.setText(modalDetailJadwals.get(i).getImsyak());
        ((MyAdapterDetailJadwal) holder).subuh.setText(modalDetailJadwals.get(i).getSubuh());
        ((MyAdapterDetailJadwal) holder).terbit.setText(modalDetailJadwals.get(i).getTerbit());
        ((MyAdapterDetailJadwal) holder).dhuha.setText(modalDetailJadwals.get(i).getDhuha());
        ((MyAdapterDetailJadwal) holder).dzuhur.setText(modalDetailJadwals.get(i).getDzuhur());
        ((MyAdapterDetailJadwal) holder).ashar.setText(modalDetailJadwals.get(i).getAshar());
        ((MyAdapterDetailJadwal) holder).maghrib.setText(modalDetailJadwals.get(i).getMaghrib());
        ((MyAdapterDetailJadwal) holder).isya.setText(modalDetailJadwals.get(i).getIsya());

    }

    @Override
    public int getItemCount() {
        return modalDetailJadwals.size();
    }
}
