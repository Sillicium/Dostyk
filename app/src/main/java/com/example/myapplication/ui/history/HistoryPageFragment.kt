package com.example.myapplication.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHistoryPageBinding
import com.example.myapplication.databinding.FragmentQrPageBinding
import com.example.myapplication.ui.restaurant.RestaurantsPageFragmentDirections

class HistoryPageFragment : BindingFragment<FragmentHistoryPageBinding>(
    FragmentHistoryPageBinding::inflate
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

    }

}