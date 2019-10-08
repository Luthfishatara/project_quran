package com.example.myquran.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.example.myquran.base.Constant;
import com.example.myquran.modal.Modal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class FragmentHome extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<Modal> modal;
    GridLayoutManager glm;
    AdapterHome adapterHome;
    RequestQueue queue;
    Context context;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        queue = Volley.newRequestQueue(getActivity());

        recyclerView = view.findViewById(R.id.recycler_view);
        modal = new ArrayList<>();
        glm = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(glm);

        getDataFromServerDenganJaringanSuperCepatYaituTelkomselSelaluDihati();


        return view;

    }

    private void getDataFromServerDenganJaringanSuperCepatYaituTelkomselSelaluDihati() {

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, Constant.ROOT_AYAT, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    for (int i = 0; i < response.length(); i++) {

                        JSONObject object = response.getJSONObject(i);
                        String nomor = object.getString("nomor");
                        String nama = object.getString("nama");
                        String asma = object.getString("asma");
                        String arti = object.getString("arti");

                        Modal modals = new Modal(nomor, nama, asma, arti);
                        modal.add(modals);
                        adapterHome = new AdapterHome(getActivity(), modal);
                        recyclerView.setAdapter(adapterHome);

                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        queue.add(arrayRequest);

    }
}