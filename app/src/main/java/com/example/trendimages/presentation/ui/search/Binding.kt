package com.example.trendimages.presentation.ui.search

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.request.RequestOptions
import com.example.trendimages.R

@BindingAdapter("imageUrl")
fun ImageView.bindImage( imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(this.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)

    }
}