package com.example.myapplication.presentation_layer.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentProfilePageBinding
import com.example.myapplication.presentation_layer.ui.registration.DialogSignUpPageFragment
import com.example.myapplication.presentation_layer.ui.registration.DialogSignUpPageFragment.Companion.e_mail_text

class ProfilePageFragment : BindingFragment<FragmentProfilePageBinding>(
    FragmentProfilePageBinding::inflate
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

        setupViews()

        setupButtons()
    }

    private fun setupViews(){
        setupUserData()

        binding.profilePageTitle.tvProfileUserName.text = e_mail_text

        binding.orderHistoryTab.ivTabIcon.setImageResource(R.drawable.ic_bag)
        binding.orderHistoryTab.tvTabDescription.setText(R.string.order_history)

        binding.userDataTab.ivTabIcon.setImageResource(R.drawable.ic_person)
        binding.userDataTab.tvTabDescription.setText(R.string.user_data)

        binding.paymentMethodTab.ivTabIcon.setImageResource(R.drawable.ic_profile_credit_card)
        binding.paymentMethodTab.tvTabDescription.setText(R.string.payment_methods)

        binding.supportServiceTab.ivTabIcon.setImageResource(R.drawable.ic_profile_support_service)
        binding.supportServiceTab.tvTabDescription.setText(R.string.support_service)

        binding.supportServiceFaqTab.ivTabIcon.setImageResource(R.drawable.ic_profile_support_service)
        binding.supportServiceFaqTab.tvTabDescription.setText(R.string.support_service_faq)

        binding.aboutCompanyTab.ivTabIcon.setImageResource(R.drawable.ic_about_company_info)
        binding.aboutCompanyTab.tvTabDescription.setText(R.string.about_company)
    }

    private fun setupButtons(){

        binding.profilePageTitle.ivNotification
            .setOnClickListener {
                val direction = ProfilePageFragmentDirections.actionBottomProfileToNotificationPageFragment()
                findNavController().navigate(direction)
            }

        binding.orderHistoryTab.tabLayout
            .setOnClickListener {
                val direction = ProfilePageFragmentDirections.actionBottomProfileToOrderHistoryFragment()
                findNavController().navigate(direction)
            }

        binding.userDataTab.tabLayout
            .setOnClickListener {
                val direction = ProfilePageFragmentDirections.actionBottomProfileToUserDataFragment()
                findNavController().navigate(direction)
            }

        binding.paymentMethodTab.tabLayout
            .setOnClickListener {
                val direction = ProfilePageFragmentDirections.actionBottomProfileToPaymentMethodFragment()
                findNavController().navigate(direction)
            }


        binding.supportServiceTab.tabLayout
            .setOnClickListener {
                val direction = ProfilePageFragmentDirections.actionBottomProfileToServiceSupportFragment()
                findNavController().navigate(direction)
            }


        binding.supportServiceFaqTab.tabLayout
            .setOnClickListener {
                val direction = ProfilePageFragmentDirections.actionBottomProfileToServiceFaqPageFragment()
                findNavController().navigate(direction)
            }


        binding.aboutCompanyTab.tabLayout
            .setOnClickListener {
                val direction = ProfilePageFragmentDirections.actionBottomProfileToAboutCompanyFragment()
                findNavController().navigate(direction)
            }
    }

    private fun setupUserData(){}
}