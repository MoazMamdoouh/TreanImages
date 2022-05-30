package com.example.trendimages.data.network

import okhttp3.ResponseBody

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T? = null, message: String) : Resource<T>(data, message)
    class Failed<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
    class NoConnection<T> : Resource<T>()
    class HideLoading<T> : Resource<T>()
}                                   