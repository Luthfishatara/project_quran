package com.example.myquran;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myquran.adapter.AdapterDetailJadwal;
import com.example.myquran.base.Constant;
import com.example.myquran.modal.ModalDetailJadwal;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONObject;

import java.util.ArrayList;

public class DetailJadwal extends AppCompatActivity {

    String id, kota, tanggal;
    RecyclerView details;
    AdapterDetailJadwal detailJadwal;
    GridLayoutManager glm;
    ArrayList<ModalDetailJadwal> detailJadwals;
    RequestQueue queue;
    SpinKitView spinkit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_jadwal);

        id = getIntent().getStringExtra("id");
        tanggal = getIntent().getStringExtra("tanggal");

        queue = Volley.newRequestQueue(getApplicationContext());
        details = findViewById(R.id.jadwal);
        spinkit = findViewById(R.id.spin_kit1);
        detailJadwals = new ArrayList<>();


        glm = new GridLayoutManager(getApplicationContext(), 1);

        sholatwajib();

    }

    private void sholatwajib() {

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, Constant.ROOT_JADWAL + id + Constant.ROOT_ENDJADWAL + tanggal, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                spinkit.setVisibility(View.VISIBLE);

                try {

                        JSONObject apa = response.getJSONObject("jadwal");
                        JSONObject obj = apa.getJSONObject("data");

                        String tanggal = obj.getString("tanggal");
                        String imsyak = obj.getString("imsak");
                        String subuh = obj.getString("subuh");
                        String terbit = obj.getString("terbit");
                        String dhuha = obj.getString("dhuha");
                        String dzuhur = obj.getString("dzuhur");
                        String ashar = obj.getString("ashar");
                        String maghrib = obj.getString("maghrib");
                        String isya = obj.getString("isya");

                        ModalDetailJadwal mdj = new ModalDetailJadwal(tanggal, imsyak, subuh, terbit, dhuha, dzuhur, ashar, maghrib, isya);
                        detailJadwals.add(mdj);
                        detailJadwal =  new AdapterDetailJadwal(detailJadwals, getApplicationContext());
                        details.setLayoutManager(glm);
                        details.setAdapter(detailJadwal);
                        spinkit.setVisibility(View.GONE);

                        Log.d("OII",  tanggal + imsyak + subuh + terbit + dhuha + dzuhur + ashar + maghrib + isya);







                }catch (Exception exs){
                    exs.printStackTrace();
                }

                Log.d("PERCOBAAN", Constant.ROOT_JADWAL + id + Constant.ROOT_ENDJADWAL + tanggal);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(objectRequest);


    }
}
