package com.example.enesyildirim.themoviedb.CustomThings;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enesyildirim.themoviedb.Data.FilmResponse;
import com.example.enesyildirim.themoviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FilmResponse> films;
    private OnMovieClickListener onMovieClickListener;

    public RecycleAdapter(List<FilmResponse> films, OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
        this.films = films;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linedesign, null);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        final FilmResponse filmResponse = films.get(position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onMovieClickListener != null) {
                    onMovieClickListener.onItemClick(filmResponse);
                }
            }
        });

        ListHolder listHolder = ((ListHolder) viewHolder);
        Picasso.get().load("http://image.tmdb.org/t/p/" + filmResponse.getPoster_path()).placeholder(R.drawable.movieicon).into(listHolder.imageView);
        listHolder.filmNameTxt.setText(filmResponse.getTitle());
        listHolder.filmDescTxt.setText(filmResponse.getOverview());
        listHolder.filmTypeTxt.setText(filmResponse.getVote_average());
        listHolder.filmYearTxt.setText(filmResponse.getRelease_date());
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {

        TextView filmNameTxt, filmDescTxt, filmTypeTxt, filmYearTxt;
        ImageView imageView;

        ListHolder(@NonNull View v) {
            super(v);
            imageView = v.findViewById(R.id.imageOfFilm);
            filmNameTxt = v.findViewById(R.id.filmNameTxt);
            filmDescTxt = v.findViewById(R.id.filmDescTxt);
            filmTypeTxt = v.findViewById(R.id.filmTypeTxt);
            filmYearTxt = v.findViewById(R.id.filmYearTxt);
        }
    }

    public interface OnMovieClickListener {
        void onItemClick(FilmResponse filmResponse);
    }
}