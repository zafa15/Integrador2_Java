package com.mytest.user.integrador2_java.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebService {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> userLogin(
      @Field("email") String email,
      @Field("password") String password
    );
}
