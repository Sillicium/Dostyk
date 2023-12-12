package com.example.myapplication.presentation_layer.ui.restaurant.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRestaurantNewsAndEventsBinding
import com.example.myapplication.ui.home.HomePageFragment
import com.example.myapplication.ui.restaurant.adapter.AllRestaurantNewsAdapter


class RestaurantNewsAndEventsFragment : BindingFragment<FragmentRestaurantNewsAndEventsBinding>(
    FragmentRestaurantNewsAndEventsBinding::inflate
), AllRestaurantNewsAdapter.AllRestaurantNewsAdapterUserClickListener {
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
        val adapter = AllRestaurantNewsAdapter(requireContext(), this).apply {
            setItems(HomePageFragment().TwoElementAdaptersData)
        }
        binding.allNewsAndEventsList.adapter = adapter

        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.restaurant_description_news_and_events_title)

    }

    private fun setupBtn(){
        binding.basePageTitleViewLayout.btnBack
            .setOnClickListener {
                findNavController().navigateUp()
            }
    }

    override fun onItemClickListener() {
        val directions = RestaurantNewsAndEventsFragmentDirections.actionRestaurantNewsAndEventsFragmentToRestaurantSuperEventFragment()
        findNavController().navigate(directions)
    }
}