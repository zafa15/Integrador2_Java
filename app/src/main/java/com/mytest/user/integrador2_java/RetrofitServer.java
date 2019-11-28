package com.mytest.user.integrador2_java;

import com.mytest.user.integrador2_java.Retrofit.WebService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {
    private static final String BASE_URL="http://127.0.0.1:8000/api/";
    private static RetrofitServer mInstance;
    private Retrofit retrofit;

    private RetrofitServer(){
                retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitServer getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitServer();
        }
        return mInstance;
    }

    public WebService getService(){
        return (WebService) retrofit.create(RetrofitServer.class);
    }
}
