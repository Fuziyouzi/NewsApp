package com.example.newsapp.presenter.base

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.newsapp.R

interface ImageLoader {

    fun load(image: String?, view: ImageView)
}
class ImageLoaderImpl: ImageLoader{
    override fun load(image: String?,view: ImageView) {
        if(image?.isNotBlank() == true){
            Glide.with(view)
                .load(image)
                .placeholder(R.drawable.sample_image)
                .error(R.drawable.sample_image)
                .into(view)
        } else {
            view.setImageResource(R.drawable.sample_image)
        }
    }

}