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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myquran.adapter.AdapterDetailQuran;
import com.example.myquran.base.Constant;
import com.example.myquran.modal.ModalDetailQuran;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailSurat extends AppCompatActivity {

    String getId;
    RecyclerView detail;
    AdapterDetailQuran detailQuran;
    GridLayoutManager glm;
    ArrayList<ModalDetailQuran> detailQurans;
    RequestQueue queue;
    SpinKitView spinKitViews;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_surat);

        queue = Volley.newRequestQueue(getApplicationContext());
        getId = getIntent().getStringExtra("nomor");
        detail = findViewById(R.id.detail);
        spinKitViews = findViewById(R.id.spin_kit2);
        detailQurans = new ArrayList<>();

        glm = new GridLayoutManager(getApplicationContext(), 1);

        apaaja();

    }

    private void apaaja() {

        JsonArrayRequest request  = new JsonArrayRequest(Request.Method.GET, Constant.ROOT_FIST + getId + Constant.ROOT_END, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                spinKitViews.setVisibility(View.VISIBLE);

              try {

                  for (int i = 0; i<response.length(); i++){

                      JSONObject obj =response.getJSONObject(i);
                      String nomor = obj.getString("nomor");
                      String name = obj.getString("ar");
                      String arti = obj.getString("id");

                      ModalDetailQuran mdq = new ModalDetailQuran(nomor, name, arti);
                      detailQurans.add(mdq);
                      detailQuran = new AdapterDetailQuran(detailQurans, getApplicationContext());
                      detail.setAdapter(detailQuran);
                      detail.setLayoutManager(glm);
                      spinKitViews.setVisibility(View.GONE);

                      Log.d("Coba", nomor + name + arti);

                  }

              }catch (Exception e) {
                  e.printStackTrace();

              }

                Log.d("PERCOBAAN", Constant.ROOT_FIST + getId + Constant.ROOT_END);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("errorrr", error + "");
            }
        });
        queue.add(request);

    }
}
