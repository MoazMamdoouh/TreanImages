package com.example.trendimages.data.repository

import android.util.Log
import com.example.trendimages.data.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.lang.Exception

abstract class BaseRepository {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {

            try {
                val response = apiCall()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        return Resource.Success(body, "")
                    }
                }
                return Resource.Failed("${response.code()} ${response.message()}")
            } catch (e: Exception) {
                return Resource.Failed(e.message ?: e.toString())
            }
        }
    }
