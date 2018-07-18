package com.example.enesyildirim.themoviedb.Data;

import java.io.Serializable;
import java.util.List;

public class MainData implements Serializable {

    private static final long serialVersionUID = 7778798398786684568L;

    private List<Genres> genres;
    private List<FilmResponse> results;

    public List<FilmResponse> getResults() {
        return results;
    }

    public void setResults(List<FilmResponse> results) {
        this.results = results;
    }

    public List<com.example.enesyildirim.themoviedb.Data.Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<com.example.enesyildirim.themoviedb.Data.Genres> genres) {
        this.genres = genres;
    }
}
