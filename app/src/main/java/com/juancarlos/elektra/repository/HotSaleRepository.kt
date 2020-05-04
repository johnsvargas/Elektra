package com.juancarlos.elektra.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.juancarlos.elektra.GetProductsQuery
import com.juancarlos.elektra.R
import com.juancarlos.elektra.model.Brand
import com.juancarlos.elektra.model.Product

class HotSaleRepository {
    private var responseBrand = MutableLiveData<ArrayList<Brand>>()
    private var responseProduct = MutableLiveData<ArrayList<Product>>()
    private var responseProductMostSold = MutableLiveData<ArrayList<Product>>()

    fun getSKU():ArrayList<String>{
        return arrayListOf("321323142", "321323076", "45025344", "45024957", "1003678",
            "321321586", "45025337", "321323141", "45035651", "45048926", "1007046",
            "1006062", "1007073", "321324716", "1006025", "1005116", "1006593",
            "1006581", "1006945", "321321538")
    }

    fun callProducts(skusList:ArrayList<String>){
        val getProductsQuery = GetProductsQuery.builder().skus(skusList).build()
        ApolloConnector.apolloClient.query(getProductsQuery).enqueue(object: ApolloCall.Callback<GetProductsQuery.Data>(){
            override fun onFailure(e: ApolloException) {
                Log.d("GRAPHQL","")
            }

            override fun onResponse(response: Response<GetProductsQuery.Data>) {
                val products:ArrayList<Product> = ArrayList()
                response.data?.viewer()?.products()?.forEach { productQuery->
                    val product = Product(productQuery.id()?:"",productQuery.name()?:""
                        ,productQuery.image()?:"", productQuery.price()?:0.0)
                    products.add(product)
                }
                val productsMostSold:ArrayList<Product> = ArrayList()

                for (index in 0..3){
                    productsMostSold.add(products[index])
                }
                responseProduct.postValue(products)
                responseProductMostSold.postValue(productsMostSold)
            }

        })
    }

    fun getProducts() = responseProduct

    fun getListProductsMostSold() = responseProductMostSold

    fun getListBrands(): MutableLiveData<ArrayList<Brand>> = responseBrand

    fun callBrands(){
        val mapBrands : Map<String,Int> = mapOf("samsung" to R.drawable.samsung,
            "italika" to R.drawable.italika, "apple" to R.drawable.apple,
            "lg" to R.drawable.lg, "huawei" to R.drawable.huawei,"nintendo" to R.drawable.nintendo)
        responseBrand.value = Brand.mapToArrayListBrands(mapBrands)
    }
}