package com.example.ezytapexample.Network;


import com.example.ezytapexample.Model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("mobileapps/android_assignment.json")
    Call<DataModel> getData();




}
