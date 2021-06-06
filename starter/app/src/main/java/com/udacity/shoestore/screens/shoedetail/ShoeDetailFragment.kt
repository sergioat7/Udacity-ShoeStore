/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 29/5/2021
 */

package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoelist.ShoesViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(layoutInflater, container, false)

        with(binding) {

            val adapter = ArrayAdapter(
                requireContext(),
                R.layout.list_item,
                resources.getStringArray(R.array.sizes)
            )
            autoCompleteTextViewShoeSize.setAdapter(adapter)
            buttonCancel.setOnClickListener {
                findNavController().navigateUp()
            }
            buttonSave.setOnClickListener {
                saveShoe()
            }
        }

        return binding.root
    }

    private fun saveShoe() {

        viewModel.addShoe(
            Shoe(
                binding.textInputEditTextShoeName.text.toString(),
                binding.autoCompleteTextViewShoeSize.text.toString().toDoubleOrNull() ?: 0.0,
                binding.textInputEditTextShoeCompany.text.toString(),
                binding.textInputEditTextShoeDescription.text.toString()
            )
        )
        findNavController().navigateUp()
    }
}