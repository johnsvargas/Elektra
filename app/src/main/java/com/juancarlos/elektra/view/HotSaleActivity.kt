package com.juancarlos.elektra.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.juancarlos.elektra.databinding.ActivityHotSaleBinding
import com.juancarlos.elektra.viewmodel.HotSaleViewModel
import kotlinx.android.synthetic.main.activity_hot_sale.*

class HotSaleActivity : AppCompatActivity() {
    private lateinit var  model : HotSaleViewModel
    private lateinit var binding: ActivityHotSaleBinding
    private var doubleBackToExitPressedOnce = false
    private var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHotSaleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model = ViewModelProvider.AndroidViewModelFactory(application).create(HotSaleViewModel::class.java)
        initActivity()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Presione otra vez back para salir", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnable {
            doubleBackToExitPressedOnce = false
        }, 2000)
    }

    private fun initActivity(){
        initActivityHard()
        initRecyclerViews()
        initButtons()
    }

    private fun initRecyclerViews(){
        binding.hBrandsRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.hBrandsRecyclerView.adapter = model.getRecyclerBrandsAdapter()
        model.callBrands()
        model.getListBrands().observe(context, Observer {
            model.setBrandsInRecyclerAdapter(it)
        })


        binding.hMostSoldRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.hMostSoldRecyclerView.adapter = model.getRecyclerProductsAdapter()
        model.callProducts()
        model.getListProducts().observe(context, Observer {
            model.setProductsInRecyclerAdapter(it)
        })

        binding.hRecommendedRecyclerView.layoutManager = GridLayoutManager(context,2)
        binding.hRecommendedRecyclerView.adapter = model.getRecyclerProductsMostSoldAdapter()
        model.getListProductsMostSold().observe(context, Observer {
            model.setProductsMostSoldInRecyclerAdapter(it)
        })
    }

    private fun initButtons(){
        binding.hTitleRecommendedLinkTextView.setOnClickListener {
            goToProductsActivity(0)
        }

        binding.hTitlemostSoldsLinkTextView.setOnClickListener {
            goToProductsActivity(0)
        }

        binding.hAccountImageView.setOnClickListener {
            goToRegisterActivity()
        }
    }

    private fun initActivityHard(){
        Glide.with(this)
            .load("http://hnoscarrasco.com/images/hotsale")
            .apply(RequestOptions.bitmapTransform( RoundedCorners(10)))
            .into(h_offert_image)
        Glide.with(this)
            .load("http://hnoscarrasco.com/images/cekt")
            .apply(RequestOptions.bitmapTransform( RoundedCorners(10)))
            .into(h_credi_image)


        category1.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/2076902-400-400/31038020.jpg")
        category1.setText("Telefonía")
        category2.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/1926707-400-400/830370.jpg")
        category2.setText("Videojuegos y coleccionables")
        category3.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/2066619-400-400/28008860.jpg")
        category3.setText("Computo")


        category4.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/2068668-400-400/34004271.jpg")
        category4.setText("Italika")
        category5.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/2093760-400-400/1007545.jpg")
        category5.setText("Pantallas")
        category6.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/453839-1000-1000/8002103.jpg")
        category6.setText("Lavadoras")

        category7.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/2143334-400-400/7002684.jpg")
        category7.setText("Refrigeradores")
        category8.setImageCircular("https://elektra.vteximg.com.br/arquivos/ids/2186535-400-400/14001894.jpg")
        category8.setText("Colchones")


        Glide.with(this)
            .load("http://hnoscarrasco.com/images/Imagen%20producto6")
            .apply(RequestOptions.bitmapTransform( RoundedCorners(30)))
            .into(h_collection1_imageView)
        Glide.with(this)
            .load("http://hnoscarrasco.com/images/Imagen%20producto5")
            .apply(RequestOptions.bitmapTransform( RoundedCorners(30)))
            .into(h_collection2_imageView)
        Glide.with(this)
            .load("http://hnoscarrasco.com/images/Imagen%20producto4")
            .apply(RequestOptions.bitmapTransform( RoundedCorners(30)))
            .into(h_collection3_imageView)
    }

    private fun goToProductsActivity(type:Int){
        val intentToProduct = Intent(context,ListProductsActivity::class.java)
        startActivity(intentToProduct)
    }

    private fun goToRegisterActivity(){
        val intentToRegister = Intent(context,RegisterActivity::class.java)
        startActivity(intentToRegister)
    }
}
