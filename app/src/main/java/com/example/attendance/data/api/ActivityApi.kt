package com.example.attendance.data.api

import com.example.attendance.data.ActivityResponseModel
import retrofit2.http.GET

interface ActivityApi {

    @GET("breeds/image/random")
    suspend fun getRandomImage(): ActivityResponseModel

}