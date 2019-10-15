package com.example.myquran.fragment;

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myquran.R;
import com.example.myquran.adapter.AdapterAlquran;
import com.example.myquran.base.Constant;
import com.example.myquran.modal.ModalServer;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentAlquran extends Fragment {

    View view;
    RecyclerView recyclerview;
    ArrayList<ModalServer> modalServers;
    GridLayoutManager gm;
    AdapterAlquran adapterAlquran;
    RequestQueue queue;
    SpinKitView spinKitView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quran, container, false);

        queue = Volley.newRequestQueue(getActivity());
        recyclerview = view.findViewById(R.id.recyclerview);
        modalServers = new ArrayList<>();
        gm = new GridLayoutManager(getContext(), 1);
        spinKitView = view.findViewById(R.id.spin_kit3);

        recyclerview.setLayoutManager(gm);

        bacaquran();

        return view;

    }

    private void bacaquran() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Constant.ROOT_AUDIO, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                spinKitView.setVisibility(View.VISIBLE);

                try {
                    JSONArray array = response.getJSONArray("reciters");

                    for (int j = 0; j < array.length(); j++){

                        JSONObject object = array.getJSONObject(j);
                        String id = object.getString("id");
                        String name = object.getString("name");
                        String Server = object.getString("Server");
                        String rewaya = object.getString("rewaya");

                        ModalServer server = new ModalServer(id, name, Server, rewaya);
                        modalServers.add(server);
                        adapterAlquran = new AdapterAlquran(getActivity(), modalServers);
                        recyclerview.setAdapter(adapterAlquran);
                        recyclerview.setLayoutManager(gm);

                        Log.d("ALQURAN", id + name + Server + rewaya);

                        spinKitView.setVisibility(View.GONE);


                    }



                }catch (Exception ex){
                    ex.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

    }
}
