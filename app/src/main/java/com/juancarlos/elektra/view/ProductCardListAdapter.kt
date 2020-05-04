package com.juancarlos.elektra.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR
import com.juancarlos.elektra.model.Product
import com.juancarlos.elektra.viewmodel.HotSaleViewModel

class ProductCardListAdapter(var model: HotSaleViewModel,var resource: Int):RecyclerView.Adapter<ProductCardListAdapter.ProductCardListHolder>() {
    private var products: ArrayList<Product>? = null

    fun setProductsList(products:ArrayList<Product>){
        this.products = products
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardListHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater,viewType,parent,false)
        return ProductCardListHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int) = resource

    override fun getItemCount() = products?.size?:0

    override fun onBindViewHolder(holder: ProductCardListHolder, position: Int) {
        holder.setDataCard(model,position)
    }


    class ProductCardListHolder(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root){
        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }
        fun setDataCard(model: HotSaleViewModel, position: Int){
            binding?.setVariable(BR.model,model)
            binding?.setVariable(BR.position,position)
            binding?.notifyChange()
        }
    }
}