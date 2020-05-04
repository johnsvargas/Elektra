package com.juancarlos.elektra.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.juancarlos.elektra.model.Product
import com.juancarlos.elektra.viewmodel.ListProductViewModel

class ProductListAdapter (var model: ListProductViewModel, var resource: Int):RecyclerView.Adapter<ProductListAdapter.ProductListHolder>() {
    private var products: ArrayList<Product>? = null

    fun setProductsList(pro:ArrayList<Product>){
        this.products = pro
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater,viewType,parent,false)
        return ProductListHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int) = resource

    override fun getItemCount() = products?.size?:0

    override fun onBindViewHolder(holder: ProductListHolder, position: Int) {
        holder.setDataCard(model,position)
    }


    class ProductListHolder(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root){
        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }
        fun setDataCard(model: ListProductViewModel, position: Int){
            binding?.setVariable(BR.model,model)
            binding?.setVariable(BR.position,position)
            binding?.notifyChange()
        }
    }
}