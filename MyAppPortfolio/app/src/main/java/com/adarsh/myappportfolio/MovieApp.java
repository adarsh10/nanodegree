package com.adarsh.myappportfolio;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MovieApp extends AppCompatActivity {

    private FragmentManager fragmentManager = getFragmentManager();
    MovieListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_app);

        if (savedInstanceState == null) {
            fragment = new MovieListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }else{
            fragment = (MovieListFragment) fragmentManager.getFragment(
                    savedInstanceState, "fragmentContent");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        fragmentManager.putFragment(savedInstanceState, "fragmentContent", fragment);
    }
}
