/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 29/5/2021
 */

package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        )

        viewModel.shoes.observe(viewLifecycleOwner, { shoes ->

            binding.linearLayoutShoes.removeAllViews()
            for (shoe in shoes) {

                val itemBinding: ItemShoeBinding =
                    DataBindingUtil.inflate(inflater, R.layout.item_shoe, container, false)
                itemBinding.shoe = shoe
                binding.linearLayoutShoes.addView(itemBinding.root)
            }
            binding.imageViewNoShoes.visibility = if (shoes.isEmpty()) View.VISIBLE else View.GONE
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.loginFragment) {
            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}