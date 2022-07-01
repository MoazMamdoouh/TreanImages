package com.example.trendimages.data.repository.predict_repo

import com.example.trendimages.data.network.Api
import com.example.trendimages.data.network.RetrofitService
import com.example.trendimages.domain.model.predict.PredictGateWay
import com.example.trendimages.domain.model.predict.PredictRequest

class PredictRepo  (
    private val api : Api = RetrofitService.provideApi()
) : PredictGateWay {
    override suspend fun requestImagePredict(predictRequest: PredictRequest) =
        api.getPredictResult(predictRequest.predictImage)
}