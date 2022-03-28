package com.example.trendimages.presentation.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trendimages.data.network.Resource
import com.example.trendimages.domain.model.LoginResponse
import com.example.trendimages.domain.model.LoginRequest
import com.example.trendimages.domain.use_case.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase = LoginUseCase()
) : ViewModel() {

    private val _observeLoginSuccess = MutableLiveData<LoginResponse>()
    private val _observeLoginError = MutableLiveData<Boolean>()

    fun onLoginClicked(loginRequest: LoginRequest) {
        Log.e("sdsdsdsd", "onLoginClicked: " )
        viewModelScope.launch {
            when (val response = loginUseCase.requestLoginCredentials(loginRequest)) {
                is Resource.Success -> {
                    _observeLoginSuccess.value = response.data!!
                    Log.e("sdsdsdsd", "SUCCESS: " )

                }
                is Resource.Failed -> {
                    _observeLoginError.value = true
                    Log.e("sdsdsdsd", "ERROR: ${response.message} " )

                }
            }
        }
    }


    val observeLoginSuccess: LiveData<LoginResponse>
        get() = _observeLoginSuccess
    val observeLoginError: LiveData<Boolean>
        get() = _observeLoginError
}