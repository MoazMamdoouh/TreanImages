package com.example.trendimages.presentation.ui.predict

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trendimages.data.network.Resource
import com.example.trendimages.domain.model.predict.PredictRequest
import com.example.trendimages.domain.model.predict.PredictResponse
import com.example.trendimages.domain.use_case.predict_use_case.PredictUseCase
import kotlinx.coroutines.launch

class PredictViewModel(
    private val predictUseCase : PredictUseCase = PredictUseCase()
) : ViewModel() {

    private val _observePredictSuccess = MutableLiveData<PredictResponse>()
    private val _observePredictError = MutableLiveData<Boolean>()


    fun sendImageClicked(predictRequest: PredictRequest)
    {

        Log.e("sdsdsdsd", "onLoginClicked: " )
        viewModelScope.launch {
            when(val response = predictUseCase.requestPredictCredentials(predictRequest))
            {
                is Resource.Success -> {
                    _observePredictSuccess.value = response.data!!
                    Log.e("sdsdsdsd", "success: " )
                }
                is Resource.Failed ->{
                    _observePredictError.value = true
                    Log.e("sdsdsdsd", "error: ${response.message}" )
                }
            }
        }
    }



    val observeSuccess : LiveData<PredictResponse>
        get() = _observePredictSuccess
    val observeError : LiveData<Boolean>
        get() = _observePredictError


}