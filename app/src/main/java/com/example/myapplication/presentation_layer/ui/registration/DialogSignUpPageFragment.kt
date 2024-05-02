package com.example.myapplication.presentation_layer.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.DialogSignUpPageBinding
import com.example.myapplication.presentation_layer.utils.fragment_utils.BaseBottomSheetDialog

class DialogSignUpPageFragment: BaseBottomSheetDialog<DialogSignUpPageBinding>(
    DialogSignUpPageBinding::inflate
) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)


        setupView()

        setupBtn()

        dialog?.setCancelable(false)

        return binding.root
    }

    private fun setupView(){
        e_mail_text = binding.eMailEditText.text.toString()

        password_text = binding.passwordEditText.text.toString()
    }

    private fun setupBtn(){
        binding.btnClose.setOnClickListener {
            dialog?.dismiss()
        }

        binding.btnSignUp.setOnClickListener {
            if (password_text.isNotBlank() && e_mail_text.isNotBlank()){
                findNavController().navigate(DialogSignUpPageFragmentDirections.actionDialogSignUpPageToBottomHome())
            }else{
                Toast.makeText(requireContext(), getString(R.string.text_is_blank), Toast.LENGTH_SHORT).show()
            }
        }
    }


    companion object {

        var e_mail_text: String = ""

        var password_text: String = ""

        const val TAG = "SignUpdDialog"
    }
}