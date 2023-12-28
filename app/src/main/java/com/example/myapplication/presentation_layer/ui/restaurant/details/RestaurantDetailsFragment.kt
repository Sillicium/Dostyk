package com.example.myapplication.presentation_layer.ui.restaurant.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.databinding.FragmentRestaurantDetailsBinding
import com.example.myapplication.presentation_layer.ui.home.HomePageFragment
import com.example.myapplication.presentation_layer.ui.restaurant.adapter.PartRestaurantsNewsAdapter

class RestaurantDetailsFragment : BindingFragment<FragmentRestaurantDetailsBinding>(
    FragmentRestaurantDetailsBinding::inflate
), PartRestaurantsNewsAdapter.PartRestaurantsNewsAdapterClickListener {

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
        val newsAndEventsAdapter = PartRestaurantsNewsAdapter(requireContext(), this).apply {
            setItems(HomePageFragment().TwoElementAdaptersData)
        }
        binding.restaurantDescriptionNewsAndEventsLayout.newsAndEventsList.adapter = newsAndEventsAdapter


        binding.restaurantDescriptionNewsAndEventsLayout.icViewAllNewsAndEvents
            .setOnClickListener {
                val directions = RestaurantDetailsFragmentDirections.actionRestaurantDetailsFragmentToRestaurantNewsAndEventsFragment()
                findNavController().navigate(directions)
            }

    }

    override fun userClickListener() {
        val directions = RestaurantDetailsFragmentDirections.actionRestaurantDetailsFragmentToRestaurantSuperEventFragment()
        findNavController().navigate(directions)
    }
}