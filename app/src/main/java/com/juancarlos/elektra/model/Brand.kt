package com.juancarlos.elektra.model

data class Brand (var idBrand: Int,var url:Int,var name :String){
    companion object{
        fun mapToArrayListBrands(map: Map<String,Int>):ArrayList<Brand>{
            var  index = 1
            val list : ArrayList<Brand> = ArrayList()
            map.forEach { (name, url) ->
                list.add(Brand(index,url,name))
                index++
            }
            return list
        }
    }
}