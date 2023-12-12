package com.example.myapplication.presentation_layer.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPaymentHistoryDetailsBinding

class PaymentHistoryDetailsFragment : BindingFragment<FragmentPaymentHistoryDetailsBinding>(
    FragmentPaymentHistoryDetailsBinding::inflate
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
        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.history_details_page_title)

        binding.tvCompanyAddressOrderHistoryLayout.ivAboutCompanyDetails.visibility = View.GONE
        binding.tvCompanyAddressOrderHistoryLayout.tvTitle.setText(R.string.restaurant_address_title)
        binding.tvCompanyAddressOrderHistoryLayout.tvDescription.setText(R.string.restaurant_address_text)

        binding.tvCompanyNameOrderHistoryPage.setText(R.string.restaurant_type_name)
        binding.tvCompanyDescriptionOrderHistoryPage.setText(R.string.restaurant_description)
    }

    private fun setupBtn(){

    }

}