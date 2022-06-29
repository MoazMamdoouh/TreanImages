package com.example.trendimages.data.network
import com.example.trendimages.domain.model.login.LoginRequest
import com.example.trendimages.domain.model.login.LoginResponse
import com.example.trendimages.domain.model.search.SearchResponse
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @POST("betrend.api.login")
    suspend fun getUserLogin(
       @Body loginRequest : LoginRequest
    ): Response<LoginResponse>
    @POST("search?")
    suspend fun getSearchResult(
        @Query("text") imageText :String,
        @Query("num") imageNumbers :Int
    ) : Response<SearchResponse>
}
