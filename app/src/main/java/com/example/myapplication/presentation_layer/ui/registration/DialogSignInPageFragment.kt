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
import com.example.myapplication.databinding.DialogSignInPageBinding
import com.example.myapplication.presentation_layer.ui.registration.DialogSignUpPageFragment.Companion.e_mail_text
import com.example.myapplication.presentation_layer.ui.registration.DialogSignUpPageFragment.Companion.password_text
import com.example.myapplication.presentation_layer.utils.fragment_utils.BaseBottomSheetDialog

class DialogSignInPageFragment: BaseBottomSheetDialog<DialogSignInPageBinding>(
    DialogSignInPageBinding::inflate
) {
    var emailEditText = ""

    var passwordEditText = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        dialog?.setCancelable(false)

        setupView()

        return binding.root
    }

    private fun setupView(){

        binding.eMailEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                emailEditText = binding.eMailEditText.text.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        binding.passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                passwordEditText = binding.passwordEditText.text.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        setupBtn(emailEditText, passwordEditText)
    }

    private fun setupBtn(email: String, password: String){
        binding.btnSignIn.setOnClickListener {
            if (email == e_mail_text && password == password_text){
                findNavController().navigate(RegistrationsPageFragmentDirections.actionRegistrationsPageFragmentToBottomHome())
            }else{
                Toast.makeText(requireContext(), getString(R.string.text_email_or_password_wrong), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClose.setOnClickListener {
            dialog?.dismiss()
        }
    }

    companion object {
        const val TAG = "SignIndDialog"
    }
}