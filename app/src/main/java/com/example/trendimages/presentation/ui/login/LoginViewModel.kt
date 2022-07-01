package com.example.trendimages.presentation.ui.login


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trendimages.data.network.Resource
import com.example.trendimages.domain.model.login.LoginResponse
import com.example.trendimages.domain.model.login.LoginRequest
import com.example.trendimages.domain.use_case.login_use_case.LoginUseCase
import com.example.trendimages.presentation.ui.animation.LoadingAnimation
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase = LoginUseCase()
) : ViewModel() {
    private val loading : LoadingAnimation = LoadingAnimation()
    private val _observeLoginSuccess = MutableLiveData<LoginResponse>()
    private val _observeLoginError = MutableLiveData<Boolean>()



    fun onLoginClicked(loginRequest: LoginRequest) {
        Log.e("sdsdsdsd", "onLoginClicked: " )
        loading.showDialog()
        viewModelScope.launch {

            when (val response = loginUseCase.requestLoginCredentials(loginRequest)) {

                is Resource.Success -> {

                    _observeLoginSuccess.value = response.data!!
                    Log.e("sdsdsdsd", "SUCCESS:  ")
                    loading.hideDialog()

                }
                is Resource.Failed -> {
                    _observeLoginError.value = true
                    Log.e("sdsdsdsd", "ERROR: ${response.message} ")
                    loading.hideDialog()

                }
            }


        }
    }

    private fun validation(userName : String , password : String)
    {
        if(userName.isEmpty())
        {

        }
        else if (password.isEmpty())
        {

        }
        else if (userName.isEmpty() && password.isEmpty())
        {

        }
    }


    val observeLoginSuccess: LiveData<LoginResponse>
        get() = _observeLoginSuccess
    val observeLoginError: LiveData<Boolean>
        get() = _observeLoginError
}