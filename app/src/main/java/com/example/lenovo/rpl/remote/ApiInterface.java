package com.example.lenovo.rpl.remote;

import com.example.lenovo.rpl.moddel.Profile;
import com.example.lenovo.rpl.moddel.profilelist;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @POST("read.php")
    Call<Profile> getProfile();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> getUser(@Field("nim") String nim,
                               @Field("pass") String pass);

    @FormUrlEncoded
    @POST("create.php")
    Call<Profile> postProfile(@Field("nim") String nim,
                                  @Field("pass") String pass,
                                  @Field("nama") String nama,
                                  @Field("jk") String jk,
                                  @Field("prodi") String prodi,
                                  @Field("fakultas") String fakultas);
    @FormUrlEncoded
    @POST("update.php")
    Call<Profile> putProfile(@Field("nim") String nim,
                                 @Field("pass") String pass,
                                 @Field("nama") String nama,
                                 @Field("jk") String jk,
                                 @Field("prodi") String prodi,
                                 @Field("fakultas") String fakultas);
    @FormUrlEncoded
    @POST("delete.php")
    Call<Profile> deleteKontak(@Field("nim") String nim);
}
