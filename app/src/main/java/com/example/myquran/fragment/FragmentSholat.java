package com.example.myquran.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myquran.R;
import com.example.myquran.adapter.AdapterHome;
import com.example.myquran.adapter.AdapterSholat;
import com.example.myquran.base.Constant;
import com.example.myquran.modal.Modal;
import com.example.myquran.modal.ModalJadwal;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentSholat extends Fragment {

    View view;
    RecyclerView recycler;
    ArrayList<ModalJadwal> jadwals;
    GridLayoutManager glm;
    AdapterSholat adapterSholat;
    RequestQueue queues;
    Context context;
    SpinKitView spinKit;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sholat, container, false);

        queues  = Volley.newRequestQueue(getActivity());
        recycler = view.findViewById(R.id.recycler);
        jadwals = new ArrayList<>();
        spinKit = view.findViewById(R.id.spin_kite);
        glm = new GridLayoutManager(getContext(), 2);

        recycler.setLayoutManager(glm);

        sholatituwajib();

        return view;
    }


    private void sholatituwajib() {

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, Constant.ROOT_SEMUA, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = response.getJSONArray("kota");

                    for (int k = 0; k<array.length(); k++){


                        JSONObject object = array.getJSONObject(k);
                        String kota = object.getString("nama");
                        String idkota = object.getString("id");


                        ModalJadwal modalj = new ModalJadwal(kota, idkota);
                        jadwals.add(modalj);
                        adapterSholat = new AdapterSholat(getActivity(), jadwals);
                        recycler.setAdapter(adapterSholat);
                        recycler.setLayoutManager(glm);
                        spinKit.setVisibility(View.GONE);

                        Log.d("Test", kota + idkota);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queues.add(objectRequest);
    }
}
