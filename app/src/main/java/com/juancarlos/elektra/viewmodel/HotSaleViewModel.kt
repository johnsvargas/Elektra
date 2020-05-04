package com.juancarlos.elektra.viewmodel

import androidx.lifecycle.ViewModel
import com.juancarlos.elektra.R
import com.juancarlos.elektra.model.Brand
import com.juancarlos.elektra.model.Product
import com.juancarlos.elektra.repository.observable.HotSaleObservable
import com.juancarlos.elektra.view.BrandCardListAdapter
import com.juancarlos.elektra.view.ProductCardListAdapter

class HotSaleViewModel:ViewModel(){
    private var observable = HotSaleObservable()
    private var brandCardAdapter: BrandCardListAdapter? = null
    private var productCardAdapter: ProductCardListAdapter? = null

    private var productCardMostAdapter: ProductCardListAdapter? = null


    //BrandsRecycler
    fun getListBrands() = observable.getListBrands()

    fun callBrands(){
        observable.callBrands()
    }

    fun setBrandsInRecyclerAdapter(brands:ArrayList<Brand>){
        brandCardAdapter?.setBrandsList(brands)
        brandCardAdapter?.notifyDataSetChanged()
    }
    fun getRecyclerBrandsAdapter():BrandCardListAdapter?{
        brandCardAdapter = BrandCardListAdapter(this, R.layout.card_brands)
        return brandCardAdapter
    }

    fun getBrandCardAt(position:Int):Brand?{
        val brand: List<Brand>? = observable.getListBrands().value
        return brand?.get(position)
    }
    //endregion

    //BrandsRecycler
    fun getListProducts() = observable.getProducts()


    fun callProducts(){
        observable.callProducts(observable.getSKU())
    }

    fun setProductsInRecyclerAdapter(products:ArrayList<Product>){
        productCardAdapter?.setProductsList(products)
        productCardAdapter?.notifyDataSetChanged()
    }
    fun getRecyclerProductsAdapter():ProductCardListAdapter?{
        productCardAdapter = ProductCardListAdapter(this, R.layout.card_product)
        return productCardAdapter
    }
    fun getProductCardAt(position:Int):Product?{
        val products: List<Product>? = observable.getProducts().value
        return products?.get(position)
    }
    //endregion

    fun getListProductsMostSold() = observable.getListProductsMostSold()

    fun setProductsMostSoldInRecyclerAdapter(products:ArrayList<Product>){
        productCardMostAdapter?.setProductsList(products)
        productCardMostAdapter?.notifyDataSetChanged()
    }
    fun getRecyclerProductsMostSoldAdapter():ProductCardListAdapter?{
        productCardMostAdapter = ProductCardListAdapter(this, R.layout.card_product_most_sold)
        return productCardMostAdapter
    }

    fun getProductMostSoldCardAt(position:Int):Product?{
        val products: List<Product>? = observable.getListProductsMostSold().value
        return products?.get(position)
    }
}