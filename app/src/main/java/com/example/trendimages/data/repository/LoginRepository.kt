package com.example.trendimages.data.repository

import com.example.trendimages.data.network.Api
import com.example.trendimages.data.network.RetrofitService
import com.example.trendimages.domain.model.LoginGetWay
import com.example.trendimages.domain.model.LoginRequest
import retrofit2.Retrofit

class LoginRepository(
    private val api: Api = RetrofitService.provideApi()
) : LoginGetWay {
    override suspend fun loginRequest(loginRequest: LoginRequest) = api.getUserLogin(loginRequest)

}
