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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
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
import com.github.ybq.android.spinkit.SpinKitView;

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
    SpinKitView spinKitViews;
    Toolbar toolbar;
    SearchView searchView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);

        queue = Volley.newRequestQueue(getActivity());

        recyclerView = view.findViewById(R.id.recycler_view);
        modal = new ArrayList<>();
        spinKitViews = view.findViewById(R.id.spin_kit);
        toolbar = view.findViewById(R.id.toolbar);
        glm = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(glm);
        recyclerView.setHasFixedSize(true);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        getDataFromServerDenganJaringanSuperCepatYaituTelkomselSelaluDihati();

        return view;

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.search_view, menu);
        MenuItem item = menu.findItem(R.id.serach);
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        searchView = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.serach).getActionView();
        searchView.setOnQueryTextListener(queryDaus);
        super.onCreateOptionsMenu(menu, inflater);
    }

    androidx.appcompat.widget.SearchView.OnQueryTextListener queryDaus = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if (adapterHome != null) {
                if (!searchView.isIconified()) {
                    adapterHome.getFilter().filter(newText);
                    adapterHome.notifyDataSetChanged();
                }

            }
            searchView.setQueryHint("Cari Surat");
            return true;
        }
    };


    private void getDataFromServerDenganJaringanSuperCepatYaituTelkomselSelaluDihati() {

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, Constant.ROOT_AYAT, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                spinKitViews.setVisibility(View.VISIBLE);

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
                        spinKitViews.setVisibility(View.GONE);

                        Log.d("DAUSMEN", nama);

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
