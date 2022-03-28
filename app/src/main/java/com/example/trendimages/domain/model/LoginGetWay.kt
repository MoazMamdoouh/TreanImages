package com.example.trendimages.domain.model

import retrofit2.Response

interface LoginGetWay {
  suspend fun loginRequest(loginRequest : LoginRequest) : Response<LoginResponse>
}