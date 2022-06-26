package com.example.trendimages.domain.model.login

import retrofit2.Response

interface LoginGetWay {
  suspend fun loginRequest(loginRequest : LoginRequest) : Response<LoginResponse>
}