package com.example.trendimages.domain.use_case.search_use_case

import com.example.trendimages.data.repository.BaseRepository
import com.example.trendimages.data.repository.search_repo.SearchRepository
import com.example.trendimages.domain.model.search.SearchGateway
import com.example.trendimages.domain.model.search.SearchRequest

class SearchUseCase(
    private val searchRepo : SearchGateway = SearchRepository()
) : BaseRepository(){
    suspend fun  requestSearchCredentials(searchRequest : SearchRequest) =
        safeApiCall { searchRepo.requestImages(searchRequest) }
}