package com.example.enesyildirim.themoviedb.Data;

import java.io.Serializable;

public class Genres implements Serializable {

    private static final long serialVersionUID = 4601582053330439793L;

    private int genres;
    private String name;

    public int getGenres() {
        return genres;
    }

    public void setGenres(int genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
