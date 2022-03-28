package com.example.trendimages.domain.use_case

import com.example.trendimages.data.repository.BaseRepository
import com.example.trendimages.data.repository.LoginRepository
import com.example.trendimages.domain.model.LoginGetWay
import com.example.trendimages.domain.model.LoginRequest

class LoginUseCase(
    private val loginRepository: LoginGetWay = LoginRepository()
) : BaseRepository() {
    suspend fun requestLoginCredentials(loginRequest: LoginRequest) =
        safeApiCall { loginRepository.loginRequest(loginRequest) }

}