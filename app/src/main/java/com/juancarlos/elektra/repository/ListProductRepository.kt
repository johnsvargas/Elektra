package com.juancarlos.elektra.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.juancarlos.elektra.GetProductsQuery
import com.juancarlos.elektra.model.Product

class ListProductRepository {
    private var responseProducts = MutableLiveData<ArrayList<Product>>()
    private var listProduct = ArrayList<Product>()

    fun getListProducts() = responseProducts

    fun setFilterListProducts(value:String){
        val listFilter = ArrayList<Product>()
        responseProducts.value?.filter { p-> p.name.toLowerCase().contains(value.toLowerCase()) }?.forEach {
           listFilter.add(it)
        }
        responseProducts.value = listFilter

    }
    fun setFilterOutListProducts(){
        responseProducts.value = listProduct
    }
    fun callListProducts(){
        val skusList =arrayListOf("321323142", "321323076", "45025344", "45024957", "1003678",
            "321321586", "45025337", "321323141", "45035651", "45048926", "1007046",
            "1006062", "1007073", "321324716", "1006025", "1005116", "1006593",
            "1006581", "1006945", "321321538")

        val getProductsQuery = GetProductsQuery.builder().skus(skusList).build()
        ApolloConnector.apolloClient.query(getProductsQuery).enqueue(object: ApolloCall.Callback<GetProductsQuery.Data>(){
            override fun onFailure(e: ApolloException) {
                Log.d("GRAPHQL","")
            }

            override fun onResponse(response: Response<GetProductsQuery.Data>) {
                val products:ArrayList<Product> = ArrayList()
                response.data?.viewer()?.products()?.forEach { productQuery->
                    val product = Product(productQuery.id()?:"",productQuery.name()?:""
                        ,productQuery.image()?:"", productQuery.price()?:0.00)
                    products.add(product)
                }
                responseProducts.postValue(products)
                listProduct = products
            }

        })
    }
}