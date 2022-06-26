package com.example.trendimages.data.repository.login_repo

import com.example.trendimages.data.network.Api
import com.example.trendimages.data.network.RetrofitService
import com.example.trendimages.domain.model.login.LoginGetWay
import com.example.trendimages.domain.model.login.LoginRequest

class LoginRepository(
    private val api: Api = RetrofitService.provideApi()
) : LoginGetWay {
    override suspend fun loginRequest(loginRequest: LoginRequest) = api.getUserLogin(loginRequest)

}
