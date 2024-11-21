package com.milord.lab3_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.milord.lab3_2.databinding.FragmentItemsBinding

class ItemsFragment : Fragment()
{
    private val viewModel = ShopListViewModel.getInstance()
    private lateinit var list: ShopList
    private lateinit var binding : FragmentItemsBinding
    private lateinit var shopListAdapter : ShopListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = FragmentItemsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val nextButton = binding.nextButton
        val backButton = binding.backButton
        val recyclerView = binding.recyclerView
        list = viewModel.shopList.value!!

        viewModel.shopList.observe(viewLifecycleOwner) { shopList ->
            list = shopList
        }

        shopListAdapter = ShopListAdapter(list.numberOfItems)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = shopListAdapter

        nextButton.setOnClickListener()
        {
            list.items.clear()
            for (i in 0 until list.numberOfItems)
            {
                val holder = recyclerView.findViewHolderForAdapterPosition(i) as ShopListViewHolder
                if (holder.itemName.text.isEmpty())
                {
                    holder.itemName.error = "Введите название товара!"
                    return@setOnClickListener
                }
                list.items.add(ShopListItem(holder.itemName.text.toString(), holder.itemCost.text.toString().toInt()))
            }
            viewModel.updateList(list)
            findNavController().navigate(R.id.action_itemsFragment_to_resultFragment)
        }

        backButton.setOnClickListener()
        {
            findNavController().navigate(R.id.action_itemsFragment_to_initFragment)
        }
    }
}