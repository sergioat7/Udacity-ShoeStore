/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 6/6/2021
 */

package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.udacity.shoestore.screens.welcome.WelcomeContentFragment

class InstructionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        val fragment = InstructionsContentFragment()
        fragment.arguments = Bundle().apply {
            putInt(WelcomeContentFragment.ARG_OBJECT, position)
        }
        return fragment
    }
}