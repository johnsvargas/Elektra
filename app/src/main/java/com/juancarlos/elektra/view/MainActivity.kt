package com.juancarlos.elektra.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import com.juancarlos.elektra.R



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val runnable = Runnable {
            val intentToHotSale = Intent(this,HotSaleActivity::class.java)
            startActivity(intentToHotSale)
            finish()
        }
        Handler().postDelayed(runnable,250)
    }
}
