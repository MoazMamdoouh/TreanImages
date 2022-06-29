package com.example.trendimages.data.repository


import com.example.trendimages.data.network.Resource
import com.example.trendimages.domain.model.login.LoginResponse
import retrofit2.Response
import java.lang.Exception

abstract class BaseRepository {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {

        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return if ((body as LoginResponse).message.success_key == 1)
                        Resource.Success(body, "")
                    else
                        Resource.Failed("${response.code()} ${response.message()}")
                }
            }
            return Resource.Failed("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return Resource.Failed(e.message ?: e.toString())
        }
    }
}
