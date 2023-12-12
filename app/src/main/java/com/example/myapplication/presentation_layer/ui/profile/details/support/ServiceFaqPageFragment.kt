package com.example.myapplication.presentation_layer.ui.profile.details.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentServiceFaqPageBinding


class ServiceFaqPageFragment : BindingFragment<FragmentServiceFaqPageBinding>(
    FragmentServiceFaqPageBinding::inflate
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

        setupButtons()
    }


    private fun setupView(){
        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.support_service_faq)
    }

    private fun setupButtons(){
        binding.basePageTitleViewLayout.btnBack
            .setOnClickListener {
                findNavController().navigateUp()
            }
    }

}