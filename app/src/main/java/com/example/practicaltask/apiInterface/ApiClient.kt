package com.example.practicaltask.apiInterface

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient{
    var BaseUrl="https://picsum.photos/"
    fun getClient(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val originalRequest: Request = chain.request()
                val newRequest: Request = originalRequest.newBuilder()
                    .build()
                chain.proceed(newRequest)
            })
            .addInterceptor(loggingInterceptor)
            .build()
        return Retrofit.Builder().baseUrl(BaseUrl).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()


    }
}