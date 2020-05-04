package com.juancarlos.elektra.customsviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.juancarlos.elektra.R

class ProductView:FrameLayout {
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
        val view = View.inflate(context, R.layout.product_view,null)
        addView(view)

    }
}