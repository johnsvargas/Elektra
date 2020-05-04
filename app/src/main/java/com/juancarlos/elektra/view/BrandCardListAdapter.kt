package com.juancarlos.elektra.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.juancarlos.elektra.model.Brand
import com.juancarlos.elektra.viewmodel.HotSaleViewModel

class BrandCardListAdapter(var model: HotSaleViewModel,var resource: Int):RecyclerView.Adapter<BrandCardListAdapter.BrandCardListHolder>()  {
    var brands : ArrayList<Brand>? = null

    fun setBrandsList(brands:ArrayList<Brand>){
        this.brands = brands
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandCardListHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater,viewType,parent,false)
        return BrandCardListHolder(binding)
    }

    override fun getItemCount() = brands?.size?:0

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int) = resource

    override fun onBindViewHolder(holder: BrandCardListHolder, position: Int) {
        holder.setDataCard(model,position)
    }

    class BrandCardListHolder(binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root){
        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }
        fun setDataCard(model: HotSaleViewModel,position: Int){
            binding?.setVariable(BR.model,model)
            binding?.setVariable(BR.position,position)
            binding?.notifyChange()
        }
    }
}