package com.juancarlos.elektra.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.juancarlos.elektra.R
import com.juancarlos.elektra.model.Product
import com.juancarlos.elektra.repository.observable.ListProductObservable
import com.juancarlos.elektra.view.ProductListAdapter
import java.util.*
import kotlin.collections.ArrayList

class ListProductViewModel:ViewModel() {
    private val observable = ListProductObservable()
    private var productListAdapter:ProductListAdapter? = null

    fun getListProducts() = observable.getListProducts()

    fun callListProducts(){
        observable.callListProducts()
    }

    fun setProductsInRecyclerAdapter(products:ArrayList<Product>){
        productListAdapter?.setProductsList(products)
        productListAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerProductsAdapter(): ProductListAdapter?{
        productListAdapter = ProductListAdapter(this, R.layout.card_list_product)
        return productListAdapter
    }

    fun setFilterRecyclerView(value: String){
        Log.d("filtro",value)
        val products = observable.getListProducts()
    }

    fun getProductCardAt(position:Int):Product?{
        val products: List<Product>? = observable.getListProducts().value
        return products?.get(position)
    }

    fun setFilterListProducts(value:String){
        observable.setFilterListProducts(value)
    }
    fun setFilterOutListProducts(){
        observable.setFilterOutListProducts()
    }
}