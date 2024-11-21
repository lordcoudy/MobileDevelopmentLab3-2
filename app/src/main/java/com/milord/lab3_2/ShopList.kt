package com.milord.lab3_2

data class ShopList(val numberOfItems : Int, val items : ArrayList<ShopListItem>) {
    companion object {
        private lateinit var instance: ShopList

        fun getInstance(): ShopList {
            instance = if (Companion::instance.isInitialized) instance else ShopList(0, ArrayList())
            return instance
        }
    }
}

data class ShopListItem(val name : String, val cost : Int)
