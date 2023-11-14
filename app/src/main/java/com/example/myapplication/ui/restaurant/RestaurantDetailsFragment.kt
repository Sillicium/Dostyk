package com.example.myapplication.ui.restaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRestaurantDetailsBinding
import com.example.myapplication.databinding.FragmentRestaurantsPageBinding

class RestaurantDetailsFragment : BindingFragment<FragmentRestaurantDetailsBinding>(
    FragmentRestaurantDetailsBinding::inflate
) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        setupFragment()

        return binding.root
    }

    private fun setupFragment() {
        setupView()

    }

    private fun setupView() {

    }
}