package com.example.lenovo.rpl;

import com.example.lenovo.rpl.moddel.User;
import com.example.lenovo.rpl.moddel.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("auth/login")
    Call<UserResponse> getUser();

    @GET("auth/login")
    Call<User> getId();


}
