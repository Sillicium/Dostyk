package com.example.myapplication.presentation_layer.ui.qr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPaymentResultBinding
import com.example.myapplication.presentation_layer.ui.qr.dialog.ChoosePaymentMethodDialogFragment.Companion.changeBtnColor
import com.example.myapplication.ui.qr.PaymentResultFragmentDirections


class PaymentResultFragment : BindingFragment<FragmentPaymentResultBinding>(
    FragmentPaymentResultBinding::inflate
) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        super.onCreateView(inflater, container, savedInstanceState)

        changeBtnColor = false

        setupFragment()

        return binding.root
    }

    private fun setupFragment() {
        setupView()

        setupBtn()
    }

    private fun setupView() {
        binding.ivPaymentResult.setImageResource(R.drawable.ic_selected_card)
        binding.tvPaymentResultText.setText(R.string.payment_result_success_text)

        binding.ivPaymentResult.setImageResource(R.drawable.ic_cancel_card)
        binding.tvPaymentResultText.setText(R.string.payment_result_failure_text)
    }

    private fun setupBtn() {

        binding.ivPaymentResult.setOnClickListener {
            val directions = PaymentResultFragmentDirections.actionPaymentResultFragmentToBottomQr()
            findNavController().navigate(directions)
        }
    }
}