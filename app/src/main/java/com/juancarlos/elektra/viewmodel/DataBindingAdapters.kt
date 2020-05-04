package com.juancarlos.elektra.viewmodel

import android.graphics.Paint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.juancarlos.elektra.R
import com.juancarlos.elektra.customsviews.ProductView
import kotlinx.android.synthetic.main.category_view.view.*

object DataBindingAdapters {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageResource(imageView: ImageView, resource: Int): Unit {
        imageView.setImageResource(resource)
    }

    @BindingAdapter("imageGlideUrl")
    @JvmStatic
    fun setImageWithGlide(productView: ProductView,resource: String){
        val image = productView.findViewById<ImageView>(R.id.pruduct_imageView)
        Glide.with(productView)
            .load(resource)
            .into(image)
    }

    @BindingAdapter("textToOldPrice")
    @JvmStatic
    fun setTextOldPrice(productView: ProductView,resource: String){
        val textView = productView.findViewById<TextView>(R.id.product_oldprice_textView)
        textView.text = resource
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    @BindingAdapter("textToPrice")
    @JvmStatic
    fun setTextToPrice(productView: ProductView,resource: String){
        val textView = productView.findViewById<TextView>(R.id.product_price_textView)
        textView.text = resource
    }

    @BindingAdapter("textFromWeekly")
    @JvmStatic
    fun setTextFromWeekly(productView: ProductView,resource: String){
        val textView = productView.findViewById<TextView>(R.id.product_fromWeekly_textView)
        textView.text = resource
    }

    @BindingAdapter("glideUrl")
    @JvmStatic
    fun setImageGlide(imageView: ImageView,resource: String){
        Glide.with(imageView.rootView)
            .load(resource)
            .into(imageView)
    }

    @BindingAdapter("textLastPrice")
    @JvmStatic
    fun setTextLastPrice(textView: TextView,resource: String){
        textView.text = String.format("De $resource")
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    @BindingAdapter("textPrice")
    @JvmStatic
    fun setTextPrice(textView: TextView,resource: String){
        textView.text = resource
    }

    @BindingAdapter("textNameProduct")
    @JvmStatic
    fun setTextFromWeek(textView: TextView,resource: String){
        textView.text = resource
    }


}