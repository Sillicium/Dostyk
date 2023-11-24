package com.example.myapplication.ui.profile.details.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.data.TemporaryDataClassTwoElement
import com.example.myapplication.data.TemporaryDataClassWithList
import com.example.myapplication.databinding.FragmentNotificationPageBinding
import com.example.myapplication.ui.history.HistoryPageFragment
import com.example.myapplication.ui.profile.details.adapters.NotificationOuterAdapter

class NotificationPageFragment : BindingFragment<FragmentNotificationPageBinding>(
    FragmentNotificationPageBinding::inflate
) {

    private val TwoElementAdaptersData = listOf(
        R.string.notofication_page_date_title to listOf(HistoryPageFragment().threeElement),
        R.string.notofication_page_date_title to listOf(HistoryPageFragment().threeElement),
        R.string.notofication_page_date_title to listOf(HistoryPageFragment().threeElement),
        R.string.notofication_page_date_title to listOf(HistoryPageFragment().threeElement),
        R.string.notofication_page_date_title to listOf(HistoryPageFragment().threeElement),
    ).map { TemporaryDataClassWithList(it.first, it.second) }

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
        val adapter = NotificationOuterAdapter(requireContext(), TwoElementAdaptersData).apply {
            setItems(TwoElementAdaptersData)
        }
        binding.listItemNotificationViewList.adapter = adapter
    }

    private fun setupButtons(){

        binding.basePageTitleViewLayout.btnBack
            .setOnClickListener {
                findNavController().navigateUp()
            }
    }

}