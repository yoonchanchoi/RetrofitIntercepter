package com.example.retrofitintercepter.network


import com.example.retrofitintercepter.CovidApi
import com.example.retrofitintercepter.CovidService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CovidRetrofit {

    private val retrofit = Retrofit.Builder()
        .baseUrl(CovidApi.DOMAIN)
        .addConverterFactory(GsonConverterFactory.create())
        .client(covidOkHttpClient(covidLoggingInterceptor()))
        .build()

    private fun covidOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient{
        val b = OkHttpClient.Builder()
        b.addInterceptor(interceptor)
        return b.build()
    }

    private fun covidLoggingInterceptor(): HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }


    val covidApiService: CovidService by lazy {
        retrofit.create(CovidService::class.java)
    }
}