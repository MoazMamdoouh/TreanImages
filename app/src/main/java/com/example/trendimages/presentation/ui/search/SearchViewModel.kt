package com.example.trendimages.presentation.ui.search

import android.util.Log
import androidx.lifecycle.*
import com.example.trendimages.data.network.Resource
import com.example.trendimages.domain.model.search.SearchRequest
import com.example.trendimages.domain.model.search.SearchResponse
import com.example.trendimages.domain.use_case.search_use_case.SearchUseCase
import kotlinx.coroutines.launch

class SearchViewModel(
 private val searchUseCase : SearchUseCase = SearchUseCase()
) :ViewModel() {


    private val _observeSearchSuccess = MutableLiveData<SearchResponse>()
    private val _observeSearchError = MutableLiveData<Boolean>()



    fun onSearchClick(searchRequest: SearchRequest){
        Log.e("sdsdsdsd", "onLoginClicked: " )
        Log.e("explain", "explain: ${searchRequest.searchText}   ")
        viewModelScope.launch {
            when(val response = searchUseCase.requestSearchCredentials(searchRequest)){
                is Resource.Success -> {
                    _observeSearchSuccess.value = response.data!!
                    Log.e("sdsdsdsd", "SUCCESS:  ")

                }
                is Resource.Failed -> {
                    _observeSearchError.value = true
                    Log.e("sdsdsdsd", "ERROR: ${response.message} ")
                }
            }
        }
    }



    val observeSearchSuccess: LiveData<SearchResponse>
        get() = _observeSearchSuccess
    val observeSearchError: LiveData<Boolean>
        get() = _observeSearchError
}