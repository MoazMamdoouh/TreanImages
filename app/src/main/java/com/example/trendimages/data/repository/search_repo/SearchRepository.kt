package com.example.trendimages.data.repository.search_repo

import com.example.trendimages.data.network.Api
import com.example.trendimages.data.network.RetrofitService
import com.example.trendimages.domain.model.search.SearchGateway
import com.example.trendimages.domain.model.search.SearchRequest

class SearchRepository (
    private val api : Api = RetrofitService.provideApi()
    ) : SearchGateway {
    override suspend fun requestImages(searchRequest: SearchRequest) =
        api.getSearchResult(searchRequest.searchText, searchRequest.numberOfImages)

}