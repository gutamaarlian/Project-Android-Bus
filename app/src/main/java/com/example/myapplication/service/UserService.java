package com.example.myapplication.service;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserService {
    @Multipart
    @POST ("user/login")
    Call<String> login(@Part("email")RequestBody email, @Part("password") RequestBody password);

}
