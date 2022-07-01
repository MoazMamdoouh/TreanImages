package com.example.trendimages.domain.model.predict

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.trendimages.BR
import com.google.gson.annotations.SerializedName

class PredictRequest : BaseObservable(){
    @get:Bindable
    @SerializedName("image_url")
    var predictImage: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.predictImage)
        }
}