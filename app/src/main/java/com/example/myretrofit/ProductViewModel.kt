package com.example.myretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {

    var productList = MutableLiveData<MutableList<Products>>()

    init {
        productList.value = mutableListOf()
    }
}