package com.cursospea.pyaprendizaje3.api;

import com.cursospea.pyaprendizaje3.models.LoginRequest;
import com.cursospea.pyaprendizaje3.models.LoginResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    // Login (retorna token)
    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);


}
