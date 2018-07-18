package com.example.enesyildirim.themoviedb.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enesyildirim.themoviedb.Data.FilmResponse;
import com.example.enesyildirim.themoviedb.R;

import java.io.Serializable;

public class MovieDetailFragment extends Fragment {
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.detailpage, container, false);
        v.setClickable(true);
        fillMovieDetails();
        return v;
    }

    void fillMovieDetails() {
        TextView filmNameTxt = v.findViewById(R.id.NameofFilmTxt);
        TextView filmDescTxt = v.findViewById(R.id.DescofFilmTxt);
        TextView filmYearTxt = v.findViewById(R.id.YearOfFilm);
        TextView filmActorsTxt = v.findViewById(R.id.ActorsOfFilm);
        ImageView imageView = v.findViewById(R.id.filmImage);

        FilmResponse movieDetails = (FilmResponse) getArguments().getSerializable("details");

        filmNameTxt.setText(movieDetails.getTitle());
        filmDescTxt.setText(movieDetails.getOverview());
        filmYearTxt.setText(movieDetails.getRelease_date());
        filmActorsTxt.setText(movieDetails.getVote_average());
    }
}
