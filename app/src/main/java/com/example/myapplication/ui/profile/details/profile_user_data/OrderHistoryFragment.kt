package com.example.myapplication.ui.profile.details.profile_user_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOrderHistoryBinding
import com.example.myapplication.ui.history.HistoryPageFragment
import com.example.myapplication.ui.history.PaymentHistoryAdapter


class OrderHistoryFragment : BindingFragment<FragmentOrderHistoryBinding>(
    FragmentOrderHistoryBinding::inflate
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
        binding.basePageTitleViewLayout.tvNotificationPageTitle.setText(R.string.order_history)

        val historyAdapter = PaymentHistoryAdapter(requireContext()).apply {
            setItems(listOf(HistoryPageFragment().threeElement) )
        }

        binding.paymentHistoryList.adapter = historyAdapter
    }

    private fun setupButtons(){

        binding.basePageTitleViewLayout.btnBack
            .setOnClickListener {
                findNavController().navigateUp()
            }
    }
}