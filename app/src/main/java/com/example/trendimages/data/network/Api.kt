package com.example.trendimages.data.network
import com.example.trendimages.domain.model.LoginRequest
import com.example.trendimages.domain.model.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @POST("betrend.api.login?")
    suspend fun getUserLogin(
       @Body loginRequest : LoginRequest
    ): Response<LoginResponse>
}
