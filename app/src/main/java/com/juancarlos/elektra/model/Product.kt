package com.juancarlos.elektra.model

data class Product(var id: String, var name: String,
                   var image: String, var price: Double){
    fun getFromWeek():String{
        return "Desde $106.00 Semanales"
    }

    fun getPriceString():String{
        return String.format("$%.2f",this.price)
    }

    fun getLastPriceString():String{
        val lastPrice = this.price + 100.00
        return String.format("$%.2f",lastPrice)
    }
}