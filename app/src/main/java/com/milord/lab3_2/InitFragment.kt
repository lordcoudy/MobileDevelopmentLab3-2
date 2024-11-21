package com.milord.lab3_2

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.milord.lab3_2.databinding.FragmentInitBinding
import kotlin.getValue

private val viewModel = ShopListViewModel.getInstance()
private lateinit var list: ShopList
private lateinit var binding : FragmentInitBinding

class InitFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        binding = FragmentInitBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val number = binding.numberPicker
        val startButton = binding.startButton
        list = ShopList(0, ArrayList())
        viewModel.shopList.observe(viewLifecycleOwner) { shopList ->
            list = shopList
        }

        number.maxValue = 20
        number.minValue = 1

        startButton.setOnClickListener()
        {
            if (number.value < 1)
            {
                Toast.makeText(context, "Введите количество товаров!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            list = ShopList(number.value, ArrayList())
            viewModel.updateList(list)
            findNavController().navigate(R.id.action_initFragment_to_itemsFragment)
        }

    }
}