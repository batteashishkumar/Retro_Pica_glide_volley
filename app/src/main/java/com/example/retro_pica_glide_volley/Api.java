package com.example.retro_pica_glide_volley;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {
   // String BASE_URL = "https://api.androidhive.info/json/";

    @GET

    Call<ResponseBody> call(@Url String url);
}
