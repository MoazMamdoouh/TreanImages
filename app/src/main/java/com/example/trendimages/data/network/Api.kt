package com.example.trendimages.data.network
import com.example.trendimages.domain.model.login.LoginRequest
import com.example.trendimages.domain.model.login.LoginResponse
import com.example.trendimages.domain.model.predict.PredictResponse
import com.example.trendimages.domain.model.search.SearchResponse
import retrofit2.Response
import retrofit2.http.*

interface Api {
    //login
    @POST("betrend.api.login")
    suspend fun getUserLogin(
       @Body loginRequest : LoginRequest
    ): Response<LoginResponse>
    //search
    @POST("search?")
    suspend fun getSearchResult(
        @Query("text") imageText :String,
        @Query("num") imageNumbers :Int
    ) : Response<SearchResponse>
    //predict
    @POST("betrend.api.predict?")
    suspend fun getPredictResult(
        @Query("image_url") imageUrl :String
    ): Response<PredictResponse>

}
