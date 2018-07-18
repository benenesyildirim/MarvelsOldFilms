package com.example.enesyildirim.themoviedb.RetroFit;

import com.example.enesyildirim.themoviedb.Data.MainData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("4/list/1?api_key=1282b76bc545a3a1704e15ab0ddf8352&sort_by=release_date.asc")
    Call<MainData> getMovie();
}
