package com.example.trendimages.presentation.ui.animation

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.example.trendimages.R

class LoadingAnimation {
    private lateinit var dialog : Dialog
    private lateinit var context : Context
     fun showDialog()
    {
        dialog = context.let { Dialog(it) }
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.loading_animation)
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }
    fun hideDialog()
   {
       dialog.dismiss()
   }
}