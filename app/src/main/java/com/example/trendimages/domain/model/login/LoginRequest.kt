package com.example.trendimages.domain.model.login
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.trendimages.BR
import com.google.gson.annotations.SerializedName


class LoginRequest :BaseObservable(){
    @get:Bindable
    @SerializedName("usr")
    var loginUserName: String = ""
        set(value) {
            field = value
           notifyPropertyChanged(BR.loginUserName)
        }

    @get:Bindable
    @SerializedName("pwd")
    var loginPassword: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.loginPassword)
        }
}