package com.juancarlos.elektra.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel:ViewModel(){
    private var password = MutableLiveData<String>()

    fun getPassword() = password
}