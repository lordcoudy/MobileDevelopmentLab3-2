package com.milord.lab3_2

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShopListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
{
    val itemName : EditText = itemView.findViewById(R.id.itemName)
    val itemCost : EditText = itemView.findViewById(R.id.itemCost)
}

class ShopListViewHolderEx(itemView: View): RecyclerView.ViewHolder(itemView)
{
    val itemName : TextView = itemView.findViewById(R.id.itemNameEx)
    val itemCost : TextView = itemView.findViewById(R.id.itemCostEx)
}