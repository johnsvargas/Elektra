package com.juancarlos.elektra.customsviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.juancarlos.elektra.R

class CategoryView : FrameLayout{
    constructor(context: Context, attr: AttributeSet, defStyle:Int ):super(context, attr, defStyle){
        initView(context)
    }

    constructor(context: Context, attr: AttributeSet):super(context, attr){
        initView(context)
    }

    constructor(context: Context):super(context){
        initView(context)
    }

    private fun initView(context: Context){
        val view = View.inflate(context, R.layout.category_view,null)
        addView(view)

    }

    fun setImageCircular(url:String){
        val image = this.findViewById<ImageView>(R.id.device_image)
        Glide.with(this)
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(image)
    }

    fun setText(text:String){
        val title = this.findViewById<TextView>(R.id.device_text)
        title.text = text
    }

}