   package com.example.trendimages.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitService {

    private fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }

    private fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor)
            : OkHttpClient = OkHttpClient
        .Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(" https://app.betrend.live/api/method/")
        .client(providesOkHttpClient(providesHttpLoggingInterceptor()))
        .build()

    fun provideApi(): Api = provideRetrofit().create(Api::class.java)


}


