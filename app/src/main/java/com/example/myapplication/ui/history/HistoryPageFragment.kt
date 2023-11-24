package com.example.myapplication.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.data.TemporaryDataClassOneElement
import com.example.myapplication.data.TemporaryDataClassThreeElement
import com.example.myapplication.databinding.FragmentHistoryPageBinding

class HistoryPageFragment : BindingFragment<FragmentHistoryPageBinding>(
    FragmentHistoryPageBinding::inflate
) {

    private val OneElementAdaptersData = listOf(
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
    )

    private val SecondElementAdaptersData = listOf(
        R.drawable.ic_google,
        R.string.order_history,
        R.string.order_history,
        R.string.order_history,
        R.string.order_history,
    )

    private val ThirdElementAdaptersData = listOf(
        R.drawable.ic_google,
        R.string.about_company,
        R.string.about_company,
        R.string.about_company,
        R.string.about_company,
    )

    var index = 0

    open val threeElement = TemporaryDataClassThreeElement(OneElementAdaptersData[index],
        SecondElementAdaptersData[index],
        ThirdElementAdaptersData[index])

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

        val historyAdapter = PaymentHistoryAdapter(requireContext()).apply {
            setItems(listOf(threeElement) )
        }

        binding.notificationDetailsList.adapter = historyAdapter

        binding.tvOrderHistoryPageText.setOnClickListener {
            index++
        }
    }
    private fun setupBtn(){

    }

}