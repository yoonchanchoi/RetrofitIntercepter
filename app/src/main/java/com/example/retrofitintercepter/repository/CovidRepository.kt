package com.example.retrofitintercepter.repository

import com.example.retrofitintercepter.network.CovidRetrofit

class CovidRepository {

    fun getCovidInfo(serviceKey: String) =
        CovidRetrofit.covidApiService.getDocument(serviceKey)

}