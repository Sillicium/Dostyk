package com.example.myapplication.ui.restaurant.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.databinding.FragmentRestaurantDetailsBinding

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

        setupBtn()
    }

    private fun setupBtn(){
        binding.restaurantImageLayout.icBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupView() {

    }
}