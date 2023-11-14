package com.example.myapplication.ui.profile.details.profile_user_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPaymentMethodBinding


class PaymentMethodFragment : BindingFragment<FragmentPaymentMethodBinding>(
    FragmentPaymentMethodBinding::inflate
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
        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.payment_methods)
    }

    private fun setupButtons() {

        binding.basePageTitleViewLayout.btnBack
            .setOnClickListener {
                findNavController().navigateUp()
            }

        binding.btnAddCard
            .setOnClickListener {
                AddNewCardDialog().show(parentFragmentManager, AddNewCardDialog.TAG)
            }
    }
}