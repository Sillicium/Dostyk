package com.example.myapplication.presentation_layer.ui.registration

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.DialogSignUpPageBinding
import com.example.myapplication.presentation_layer.utils.fragment_utils.BaseBottomSheetDialog
import java.util.Timer
import java.util.TimerTask

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


        binding.eMailEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                e_mail_text = binding.eMailEditText.text.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        binding.passwordEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                password_text = binding.passwordEditText.text.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        binding.btnSignUp.setOnClickListener {
            if (password_text.isNotBlank() && e_mail_text.isNotBlank()){
                findNavController().navigate(RegistrationsPageFragmentDirections.actionRegistrationsPageFragmentToBottomHome())
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