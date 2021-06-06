/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 6/6/2021
 */

package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsContentBinding

class InstructionsContentFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsContentBinding

    companion object {
        const val ARG_OBJECT = "position"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_instructions_content,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {

            val position = getInt(ARG_OBJECT)
            val imageId = if (position == 0) R.drawable.ic_list else R.drawable.add_shoe
            val titleId =
                if (position == 0) R.string.instructionsTitle1 else R.string.instructionsTitle2
            with(binding) {
                image = ResourcesCompat.getDrawable(resources, imageId, null)
                title = getString(titleId)
            }
        }
    }
}