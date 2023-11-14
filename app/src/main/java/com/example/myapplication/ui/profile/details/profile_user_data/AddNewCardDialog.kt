package com.example.myapplication.ui.profile.details.profile_user_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.DialogAddNewCardBinding
import com.example.myapplication.utils.fragment_utils.BaseBottomSheetDialog

class AddNewCardDialog : BaseBottomSheetDialog<DialogAddNewCardBinding>(
    DialogAddNewCardBinding::inflate
) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)


        setupBtns()

        return binding.root
    }

    private fun setupBtns(){
        binding.ivCancelIcon.setOnClickListener {
            this.dismiss()
        }
    }


    companion object {
        const val TAG = "AddNewCardDialog"
    }
}