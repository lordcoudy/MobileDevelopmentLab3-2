package com.milord.lab3_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ShopListAdapter (private val listSize: Int) : RecyclerView.Adapter<ShopListViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder
    {
        val viewLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.shop_list_item,
            parent,false)
        return ShopListViewHolder(viewLayout)
    }

    override fun getItemCount() = listSize
    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int)
    {
        holder.itemName.hint = holder.itemName.hint.toString() + "${position+1}"
    }
}

class ShopListAdapterEx (private val list : ShopList) : RecyclerView.Adapter<ShopListViewHolderEx>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolderEx
    {
        val viewLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.ex_shop_list_item,
            parent,false)
        return ShopListViewHolderEx(viewLayout)
    }

    override fun getItemCount() = list.numberOfItems
    override fun onBindViewHolder(holder: ShopListViewHolderEx, position: Int)
    {
        holder.itemName.text = list.items[position].name
        holder.itemCost.text = list.items[position].cost.toString()
    }
}