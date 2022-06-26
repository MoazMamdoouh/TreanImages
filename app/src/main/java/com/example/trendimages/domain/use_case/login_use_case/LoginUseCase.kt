package com.example.trendimages.domain.use_case.login_use_case

import com.example.trendimages.data.repository.BaseRepository
import com.example.trendimages.data.repository.login_repo.LoginRepository
import com.example.trendimages.domain.model.login.LoginGetWay
import com.example.trendimages.domain.model.login.LoginRequest

class LoginUseCase(
    private val loginRepository: LoginGetWay = LoginRepository()
) : BaseRepository() {
    suspend fun requestLoginCredentials(loginRequest: LoginRequest) =
        safeApiCall { loginRepository.loginRequest(loginRequest) }

}