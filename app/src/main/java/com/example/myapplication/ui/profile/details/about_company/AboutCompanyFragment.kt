package com.example.myapplication.ui.profile.details.about_company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAboutCompanyBinding

class AboutCompanyFragment :  BindingFragment<FragmentAboutCompanyBinding>(
    FragmentAboutCompanyBinding::inflate
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
        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.about_company)

        binding.aboutCompanyOffer.tvTabDescription.setText(R.string.about_company_page_offer)
        binding.aboutCompanyPrivacyPolicy.tvTabDescription.setText(R.string.about_company_page_privacy_policy)
        binding.aboutCompanyUserAgreement.tvTabDescription.setText(R.string.about_company_page_user_agreement)
    }

    private fun setupButtons(){
        binding.basePageTitleViewLayout.btnBack
            .setOnClickListener {
                val directions = AboutCompanyFragmentDirections.actionAboutCompanyFragmentToBottomProfile()
                findNavController().navigate(directions)
            }

        binding.aboutCompanyOffer.tabLayout
            .setOnClickListener {
                val directions = AboutCompanyFragmentDirections.actionAboutCompanyFragmentToAboutCompanyOfferPageFragment()
                findNavController().navigate(directions)
            }

        binding.aboutCompanyPrivacyPolicy.tabLayout
            .setOnClickListener {
                val directions = AboutCompanyFragmentDirections.actionAboutCompanyFragmentToAboutCompanyPrivacyPolicyFragment()
                findNavController().navigate(directions)
            }

        binding.aboutCompanyUserAgreement.tabLayout
            .setOnClickListener {
                val directions = AboutCompanyFragmentDirections.actionAboutCompanyFragmentToAboutCompanyUserAgreementFragment()
                findNavController().navigate(directions)
            }
    }

}
