package com.example.myapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHistoryPageBinding
import com.example.myapplication.databinding.FragmentHomePageBinding


class HomePageFragment : BindingFragment<FragmentHomePageBinding>(
    FragmentHomePageBinding::inflate
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
        binding.fragmentTopBarLayout.searchInputLayout.isHintEnabled = false

    }
    private fun setupBtn(){

    }
}