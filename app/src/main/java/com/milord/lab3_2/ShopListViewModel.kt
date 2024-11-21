package com.milord.lab3_2

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopListViewModel : ViewModel()
{
    private val _shopList = MutableLiveData<ShopList>()
    val shopList: LiveData<ShopList> = _shopList

    fun updateList(list : ShopList) {
        _shopList.value = list
    }

    companion object{
        private lateinit var instance: ShopListViewModel

        @MainThread
        fun getInstance(): ShopListViewModel
        {
            instance = if(Companion::instance.isInitialized) instance else ShopListViewModel()
            return instance
        }
    }
}