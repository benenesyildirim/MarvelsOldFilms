package com.example.enesyildirim.themoviedb.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.enesyildirim.themoviedb.CustomThings.RecycleAdapter;
import com.example.enesyildirim.themoviedb.Data.FilmResponse;
import com.example.enesyildirim.themoviedb.Data.MainData;
import com.example.enesyildirim.themoviedb.R;
import com.example.enesyildirim.themoviedb.RetroFit.API;
import com.example.enesyildirim.themoviedb.RetroFit.RequestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListFragment extends Fragment implements RecycleAdapter.OnMovieClickListener {

    private View view;
    private RecycleAdapter recycleAdapter;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mainfragment, container, false);

        setHasOptionsMenu(true);

        RequestInterface requestInterface = API.getClient().create(RequestInterface.class);
        Call<MainData> call = requestInterface.getMovie();

        call.enqueue(new Callback<MainData>() {
            @Override
            public void onResponse(Call<MainData> call, Response<MainData> response) {
                Log.d("Hoşgeldin!", "!!!onResponse onResponse onResponse onRepspnse!!!");
                if (response.isSuccessful()) {
                    recyclerView = view.findViewById(R.id.recyclerview);
                    recycleAdapter = new RecycleAdapter(response.body().getResults(), MovieListFragment.this);
                    recyclerView.setAdapter(recycleAdapter);

                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    //recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                }
            }

            @Override
            public void onFailure(Call<MainData> call, Throwable t) {
                Log.d("See Ya!", "onFailure onFailure onFailure");
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {//Burası benim actionBar'daki butonum için çağrım yapıyor!!
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.actionbarbuttons, menu);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//ActionBar'daki butonun listenerı

        switch (item.getItemId()) {
            case R.id.favoriteFilmsBtn:
               recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
               Toast.makeText(getContext(),"Layout Has Changed!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.hello1Btn:
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                Toast.makeText(getContext(),"Layout Has Changed!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.hello2Btn:
                LinearLayoutManager llm = new LinearLayoutManager(getContext());
                llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(llm);
                Toast.makeText(getContext(),"Layout Has Changed!",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(FilmResponse filmResponse) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("details", filmResponse);
        movieDetailFragment.setArguments(bundle);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, movieDetailFragment, "MovieDetailFragment");
        transaction.addToBackStack("MovieDetailFragment");
        transaction.commit();
    }
}
