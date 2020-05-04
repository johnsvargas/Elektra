package com.juancarlos.elektra.repository.observable

import com.juancarlos.elektra.repository.HotSaleRepository

class HotSaleObservable {
    private val hotSaleRepository = HotSaleRepository()

    fun getSKU():ArrayList<String>{
        return hotSaleRepository.getSKU()
    }

    fun callProducts(skusList:ArrayList<String>){
        hotSaleRepository.callProducts(skusList)
    }

    fun getProducts() = hotSaleRepository.getProducts()

    fun getListProductsMostSold() = hotSaleRepository.getListProductsMostSold()

    fun getListBrands() = hotSaleRepository.getListBrands()

    fun callBrands(){
        hotSaleRepository.callBrands()
    }
}