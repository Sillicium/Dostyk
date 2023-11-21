package com.example.myapplication.ui.qr.dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentConfirmPaymentDialogBinding
import com.example.myapplication.databinding.FragmentPaymentHistoryDetailsBinding
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

    }
}