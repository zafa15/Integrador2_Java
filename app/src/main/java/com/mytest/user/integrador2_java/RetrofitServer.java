package com.mytest.user.integrador2_java;

import com.mytest.user.integrador2_java.Retrofit.WebService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {
    private static final String BASE_URL="http://127.0.0.1:8000/api/";

    private RetrofitServer(){
                Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                RetrofitServer retrofitServer = (RetrofitServer) retrofit.create(WebService.class);

    }
}
