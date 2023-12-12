package com.example.myapplication.presentation_layer.ui.qr.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentConfirmPaymentDialogBinding
import com.example.myapplication.ui.qr.PaymentPageFragmentDirections
import com.example.myapplication.ui.qr.dialog.ChoosePaymentMethodDialogFragment.Companion.changeBtnColor
import com.example.myapplication.presentation_layer.utils.fragment_utils.BaseBottomSheetDialog

class ConfirmPaymentDialogFragment : BaseBottomSheetDialog<FragmentConfirmPaymentDialogBinding>(
    FragmentConfirmPaymentDialogBinding::inflate
) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        setupView()
        setupBtn()
        return binding.root
    }

    private fun setupView(){
        when (changeBtnColor){
            true ->binding.btnPay.setBackgroundResource(R.drawable.bg_main_button)

            else -> {binding.btnPay.setBackgroundResource(R.drawable.bg_main_button_inactive)}
        }
    }

    private fun setupBtn(){
        binding.ivCancelIcon.setOnClickListener {
            this.dismiss()
        }

        binding.choosePaymentMethodTab.tabLayout
            .setOnClickListener {
                this.dismiss()
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