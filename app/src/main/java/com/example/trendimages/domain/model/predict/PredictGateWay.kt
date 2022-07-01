package com.example.trendimages.domain.model.predict

import retrofit2.Response

interface PredictGateWay {
    suspend fun requestImagePredict(predictRequest: PredictRequest) : Response<PredictResponse>
}