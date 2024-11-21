package com.milord.lab3_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.milord.lab3_2.databinding.FragmentItemsBinding
import com.milord.lab3_2.databinding.FragmentResultBinding

class ResultFragment : Fragment()
{
    private val viewModel = ShopListViewModel.getInstance()
    private lateinit var list: ShopList
    private lateinit var binding : FragmentResultBinding
    private lateinit var shopListAdapter : ShopListAdapterEx
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val returnButton = binding.backButton2
        val recyclerView = binding.recyclerResultView
        list = viewModel.shopList.value!!

        viewModel.shopList.observe(viewLifecycleOwner) { shopList ->
            list = shopList
        }

        shopListAdapter = ShopListAdapterEx(list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = shopListAdapter

        returnButton.setOnClickListener()
        {
            findNavController().navigate(R.id.action_resultFragment_to_initFragment)
        }
    }
}