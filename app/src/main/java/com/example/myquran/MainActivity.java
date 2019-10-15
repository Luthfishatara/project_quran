package com.example.myquran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.myquran.fragment.FragmentAlquran;
import com.example.myquran.fragment.FragmentHome;
import com.example.myquran.fragment.FragmentSholat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout frame;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        frame = findViewById(R.id.frame);
        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new FragmentHome());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        menu.clear();
        inflater.inflate(R.menu.search_view, menu);
        MenuItem item = menu.findItem(R.id.serach);
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        searchView = (SearchView) menu.findItem(R.id.serach).getActionView();
        searchView.setOnQueryTextListener(queryDaus);
        return super.onCreateOptionsMenu(menu);
    }

    SearchView.OnQueryTextListener queryDaus = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return true;
        }
    };

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null ){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();

            return true;
        }

        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int userId = menuItem.getItemId();
        Fragment f = null;

        switch (userId){

            case R.id.home:
                f = new FragmentHome();
                break;

            case R.id.quran:
                f = new FragmentAlquran();
                break;

            case R.id.sholat:
                f = new FragmentSholat();
                break;

        }
        return loadFragment(f);

    }
}
