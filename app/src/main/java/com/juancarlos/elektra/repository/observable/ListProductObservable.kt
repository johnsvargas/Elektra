package com.juancarlos.elektra.repository.observable

import com.juancarlos.elektra.repository.ListProductRepository

class ListProductObservable {
    private  val listProductRepository = ListProductRepository()

    fun getListProducts() = listProductRepository.getListProducts()

    fun callListProducts(){
        listProductRepository.callListProducts()
    }

    fun setFilterListProducts(value:String){
        listProductRepository.setFilterListProducts(value)
    }
    fun setFilterOutListProducts(){
        listProductRepository.setFilterOutListProducts()
    }
}