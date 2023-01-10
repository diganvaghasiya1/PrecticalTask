package com.example.practicaltask.apiInterface

import com.example.practicaltask.model.ImageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("/v2/list")
    suspend fun getImageList(@Query("page") page: Int, @Query("limit") limite: Int):Response<ImageList>
}