package com.example.retrofit_with_recyclerview;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("posts")
    Call<ArrayList<Data>> dataCall();
}
