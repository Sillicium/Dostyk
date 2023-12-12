package com.example.myapplication.presentation_layer.ui.qr.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentChoosePaymentMethodDialogBinding
import com.example.myapplication.ui.qr.PaymentPageFragmentDirections
import com.example.myapplication.presentation_layer.utils.fragment_utils.BaseBottomSheetDialog

class ChoosePaymentMethodDialogFragment : BaseBottomSheetDialog<FragmentChoosePaymentMethodDialogBinding>(
    FragmentChoosePaymentMethodDialogBinding::inflate
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
        setupBtnElementVisibility()
        setupBtnElementIcons()

        binding.googlePayTab.tabLayout.setBackgroundResource(R.drawable.bg_solid_gray_outline_green_8_radius)
        binding.googlePayTab.tvTabDescription.setText(R.string.btn_g_pay)
    }

    private fun setupBtnElementVisibility(){
        binding.firstAddedCardTab.ivAboutCompanyDetails.visibility = View.GONE
        binding.secondAddedCardTab.ivAboutCompanyDetails.visibility = View.GONE
        binding.googlePayTab.ivAboutCompanyDetails.visibility = View.GONE
    }

    private fun setupBtnElementIcons(){
        binding.firstAddedCardTab.ivTabIcon.setImageResource(R.drawable.ic_visa)
        binding.secondAddedCardTab.ivTabIcon.setImageResource(R.drawable.ic_mastercard)
        binding.googlePayTab.ivTabIcon.setImageResource(R.drawable.ic_google)
    }

    private fun setupBtn() {
        binding.ivCancelIcon.setOnClickListener {
            this.dismiss()
        }

        binding.btnContinue.setOnClickListener {
            changeBtnColor = true
            this.dismiss()
            ConfirmPaymentDialogFragment().show(
                parentFragmentManager,
                ConfirmPaymentDialogFragment.TAG
            )
        }
    }

    companion object {

        var changeBtnColor: Boolean = false

        const val TAG = "ChoosePaymentMethodDialog"
    }
}