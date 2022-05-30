package com.example.trendimages.domain.model

data class Message(
    val api_key: String,
    val api_secret: String,
    val email: String,
    val message: String,
    val sid: String,
    var success_key: Int,
    val username: String
)