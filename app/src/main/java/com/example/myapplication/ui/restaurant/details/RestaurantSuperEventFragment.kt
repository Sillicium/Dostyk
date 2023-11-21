package com.example.myapplication.ui.restaurant.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.databinding.FragmentRestaurantSuperEventBinding

class RestaurantSuperEventFragment : BindingFragment<FragmentRestaurantSuperEventBinding>(
    FragmentRestaurantSuperEventBinding::inflate
) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        setupFragment()

        return binding.root
    }

    private fun setupFragment(){
        setupBtn()
    }

    private fun setupBtn() {

    }
}