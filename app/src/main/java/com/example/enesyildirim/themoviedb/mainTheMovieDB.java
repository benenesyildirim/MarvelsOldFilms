package com.example.enesyildirim.themoviedb;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.enesyildirim.themoviedb.CustomThings.ExitAlertDialog;
import com.example.enesyildirim.themoviedb.Fragments.MovieListFragment;

public class mainTheMovieDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_movie_db);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, new MovieListFragment(), "ListFragment");
        transaction.addToBackStack("ListFragment");
        transaction.commit();

    }

        // This is a try for bitbucket!

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getFragments().size() > 1) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            ExitAlertDialog cdd = new ExitAlertDialog(mainTheMovieDB.this, "Are U Sure?", new ExitAlertDialog.DialogClickListener() {
                @Override
                public void onClickListener(int button_id, ExitAlertDialog exitAlertDialog) {
                    finish();
                    exitAlertDialog.dismiss();
                }
            });
            cdd.show();

        }
    }
}
