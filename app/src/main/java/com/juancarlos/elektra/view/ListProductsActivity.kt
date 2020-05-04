package com.juancarlos.elektra.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.juancarlos.elektra.databinding.ActivityListProductsBinding
import com.juancarlos.elektra.viewmodel.ListProductViewModel

class ListProductsActivity : AppCompatActivity() {
    private lateinit var  model : ListProductViewModel
    private lateinit var binding: ActivityListProductsBinding
    private var context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model = ViewModelProvider.AndroidViewModelFactory(application).create(ListProductViewModel::class.java)
        initActivity()
    }

    private fun initActivity(){
        binding.pProductsRecylcerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        binding.pProductsRecylcerView.adapter = model.getRecyclerProductsAdapter()

        model.callListProducts()
        model.getListProducts().observe(context, Observer {
            model.setProductsInRecyclerAdapter(it)
        })

        binding.pSearchTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(binding.pSearchTextView.text.toString().isEmpty() || binding.pSearchTextView.text.toString().isBlank()){
                    model.setFilterOutListProducts()
                }else{
                    model.setFilterListProducts(binding.pSearchTextView.text.toString().trim())
                    //model.setFilterRecyclerView(binding.pSearchTextView.text.toString())
                }
            }
        })

        binding.cardProductBackImageView.setOnClickListener {
            onBackPressed()
        }
    }
}
