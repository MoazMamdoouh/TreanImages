package com.example.trendimages.presentation.ui.login

import android.content.Context
import android.content.SharedPreferences

class PrefManger(context: Context) {
    //shared pref mode
    private val privateMode = 0
    //shared pref file name
    private val prefName = "sharedPreferences"
    private val Is_Login = "is_login"

  private  val pref : SharedPreferences? = context.getSharedPreferences(prefName , privateMode)
  private  val edit : SharedPreferences.Editor? = pref?.edit()


    fun setLogin(isLogin : Boolean){
        edit?.putBoolean(Is_Login , isLogin)
        edit?.commit()
    }
    fun setUserName(userName : String){
        edit?.putString("userName" , userName)
        edit?.commit()
    }
    fun isLogin() : Boolean?{
        return pref?.getBoolean(Is_Login , false)
    }
    fun getUserName() :String? {
        return pref?.getString("userName" , "")
    }
    fun removeData() {
        edit?.clear()
        edit?.commit()
    }
}