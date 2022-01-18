package com.example.demo_movie;

import com.example.demo_movie.model.AccountReqModel;
import com.example.demo_movie.model.DetailFilmResModel;
import com.example.demo_movie.model.FilmResModel;
import com.example.demo_movie.model.TokenResModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    String API_KEY = "32913c50cf3b822ce755c2d9a29f00eb";

    @GET("authentication/token/new?api_key=" + API_KEY)
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<TokenResModel> getTokenReq();

    @POST("authentication/token/validate_with_login?api_key=" + API_KEY)
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<TokenResModel> login(@Body AccountReqModel acc);

    @GET("discover/movie?api_key=" + API_KEY)
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<FilmResModel> getFilmReq();

    @GET("movie/{id}/videos?api_key=" + API_KEY + "&language=en-US")
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<DetailFilmResModel> getFilmVideoReq(@Path("id") String idFilm);
}
