package com.example.myapplication.presentation_layer.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.databinding.FragmentRegistrationPageBinding

class RegistrationsPageFragment : BindingFragment<FragmentRegistrationPageBinding>(
    FragmentRegistrationPageBinding::inflate
) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        needShowRegistrationPage = false

        setupFragment()

        return binding.root
    }

    private fun setupFragment(){

        setupBtn()
    }

    private fun setupBtn(){
        binding.btnSignIn.setOnClickListener {
            DialogSignInPageFragment().show(childFragmentManager, DialogSignInPageFragment.TAG)
        }
        binding.btnSignUp.setOnClickListener {
            DialogSignUpPageFragment().show(childFragmentManager, DialogSignInPageFragment.TAG)
        }
    }

    companion object{
        var needShowRegistrationPage = true
    }


}