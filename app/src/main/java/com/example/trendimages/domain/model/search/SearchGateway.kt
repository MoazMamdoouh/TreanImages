package com.example.trendimages.domain.model.search

import retrofit2.Response

interface SearchGateway {
    suspend fun requestImages(searchRequest : SearchRequest) : Response<SearchResponse>
}