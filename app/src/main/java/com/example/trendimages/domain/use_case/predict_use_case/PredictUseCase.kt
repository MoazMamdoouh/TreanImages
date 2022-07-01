package com.example.trendimages.domain.use_case.predict_use_case

import com.example.trendimages.data.repository.BaseRepository
import com.example.trendimages.data.repository.predict_repo.PredictRepo
import com.example.trendimages.domain.model.predict.PredictGateWay
import com.example.trendimages.domain.model.predict.PredictRequest

class PredictUseCase(
    private val predictRepo : PredictGateWay = PredictRepo()
) : BaseRepository() {
    suspend fun requestPredictCredentials(predictRequest: PredictRequest) =
        safeApiCall { predictRepo.requestImagePredict(predictRequest) }
}