package com.example.myapplication.presentation_layer.ui.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPaymentPageBinding
import com.example.myapplication.presentation_layer.ui.qr.dialog.ConfirmPaymentDialogFragment

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
        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.history_details_page_title)
    }

    private fun setupBtn() {
        binding.basePageTitleViewLayout.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnPay.setOnClickListener {
            ConfirmPaymentDialogFragment().show(
                childFragmentManager,
                ConfirmPaymentDialogFragment.TAG
            )
        }
    }
}