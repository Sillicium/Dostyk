package com.example.myapplication.ui.qr.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentConfirmPaymentDialogBinding
import com.example.myapplication.ui.qr.PaymentPageFragmentDirections
import com.example.myapplication.utils.fragment_utils.BaseBottomSheetDialog

class ConfirmPaymentDialogFragment : BaseBottomSheetDialog<FragmentConfirmPaymentDialogBinding>(
    FragmentConfirmPaymentDialogBinding::inflate
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
        binding.choosePaymentMethodTab.tabLayout
            .setOnClickListener {
                ChoosePaymentMethodDialogFragment().show(
                    parentFragmentManager,
                    ChoosePaymentMethodDialogFragment.TAG
                )
            }

        binding.btnPay.setOnClickListener {
            val direction = PaymentPageFragmentDirections.actionPaymentPageFragmentToPaymentResultFragment()
            findNavController().navigate(direction)
        }
    }

    companion object {
        const val TAG = "ConfirmPaymentDialog"
    }
}