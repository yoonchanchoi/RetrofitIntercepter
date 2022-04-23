package com.example.retrofitintercepter

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidService{
    @GET("/korea/country/new/")
    fun getDocument(@Query("serviceKey") serviceKey: String): Call<StateVO>
}