package com.example.myapplication.ui.profile.details.about_company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAboutCompanyOfferPageBinding


class AboutCompanyOfferPageFragment :  BindingFragment<FragmentAboutCompanyOfferPageBinding>(
    FragmentAboutCompanyOfferPageBinding::inflate
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

        setupButtons()
    }


    private fun setupView(){
        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.about_company_page_offer)
    }

    private fun setupButtons(){
        binding.basePageTitleViewLayout.btnBack
            .setOnClickListener {
                val directions = AboutCompanyOfferPageFragmentDirections.actionAboutCompanyOfferPageFragmentToAboutCompanyFragment()
                findNavController().navigate(directions)
            }
    }

}