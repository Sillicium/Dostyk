package com.example.myapplication.presentation_layer.ui.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.databinding.FragmentRestaurantsPageBinding
import com.example.myapplication.ui.restaurant.RestaurantsPageFragmentDirections

class RestaurantsPageFragment : BindingFragment<FragmentRestaurantsPageBinding>(
    FragmentRestaurantsPageBinding::inflate
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

        setupView()

        setupBtn()
    }

    private fun setupView(){

    }

    private fun setupBtn(){
        binding.placeholder.setOnClickListener {
            val directions = RestaurantsPageFragmentDirections.actionBottomRestaurantToRestaurantDetailsFragment()
            findNavController().navigate(directions)
        }
    }
}