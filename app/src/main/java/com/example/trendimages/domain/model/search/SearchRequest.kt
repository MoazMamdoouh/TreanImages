package com.example.trendimages.domain.model.search

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.trendimages.BR

import com.google.gson.annotations.SerializedName

class SearchRequest : BaseObservable() {
    @get:Bindable
    @SerializedName("texxt")

    var searchText: String = ""
        set(value) {
            field = value
          notifyPropertyChanged(BR.searchText)
        }

    @get:Bindable
    @SerializedName("num")
    var numberOfImages: Int = 0
        set(value) {
            field = value
           notifyPropertyChanged(BR.numberOfImages)
        }
}