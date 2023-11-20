package com.example.myapplication.ui.qr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPaymentPageBinding
import com.example.myapplication.databinding.FragmentRestaurantDetailsBinding
import com.example.myapplication.ui.restaurant.details.RestaurantDetailsFragmentDirections

class PaymentPageFragment : BindingFragment<FragmentPaymentPageBinding>(
    FragmentPaymentPageBinding::inflate
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

    private fun setupView() {

    }

    private fun setupBtn() {
        binding.basePageTitleViewLayout.btnBack.setOnClickListener {
            val directions = PaymentPageFragmentDirections.actionPaymentPageFragmentToBottomQr()
            findNavController().navigate(directions)
        }
    }

}