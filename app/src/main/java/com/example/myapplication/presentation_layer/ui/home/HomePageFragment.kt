package com.example.myapplication.presentation_layer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.R
import com.example.myapplication.data_layer.model.TemporaryDataClassOneElement
import com.example.myapplication.data_layer.model.TemporaryDataClassTwoElement
import com.example.myapplication.databinding.FragmentHomePageBinding
import com.example.myapplication.presentation_layer.ui.home.adapters.HomePage1Adapter
import com.example.myapplication.presentation_layer.ui.home.adapters.NewPlacesAdapter
import com.example.myapplication.presentation_layer.ui.home.adapters.TopBrandsAdapter
import com.example.myapplication.presentation_layer.ui.registration.RegistrationsPageFragment
import com.example.myapplication.presentation_layer.ui.registration.RegistrationsPageFragment.Companion.needShowRegistrationPage


class HomePageFragment : BindingFragment<FragmentHomePageBinding>(
    FragmentHomePageBinding::inflate
) {

    private val OneElementAdaptersData = listOf(
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
        R.drawable.ic_google,
    )

    private val oneElement = TemporaryDataClassOneElement(OneElementAdaptersData[4])

     val TwoElementAdaptersData = listOf(
        R.drawable.place_holder_image to R.string.about_company,
        R.drawable.place_holder_image to R.string.about_company,
        R.drawable.place_holder_image to R.string.about_company,
        R.drawable.place_holder_image to R.string.about_company,
        R.drawable.place_holder_image to R.string.about_company,
        R.drawable.place_holder_image to R.string.about_company,
    ).map { TemporaryDataClassTwoElement(it.first, it.second) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        if (needShowRegistrationPage){
            findNavController().navigate(HomePageFragmentDirections.actionBottomHomeToRegistrationsPageFragment())
        }else{
            setupFragment()
        }

        return binding.root
    }

    private fun setupFragment(){

        setupView()

        setupBtn()
    }

    private fun setupView(){
        binding.fragmentTopBarLayout.searchInputLayout.isHintEnabled = false


        val topBrandsAdapter = TopBrandsAdapter(requireContext()).apply {
            setItems(TwoElementAdaptersData)
        }

        val newPlacesAdapter = NewPlacesAdapter(requireContext()).apply {
            setItems(TwoElementAdaptersData)
        }

        val homePage1Adapter = HomePage1Adapter(requireContext()).apply {
            setItems(listOf(oneElement))
        }
        binding.recyclerView.adapter = homePage1Adapter

        binding.topBrandsLayout.topBrandsList.adapter = topBrandsAdapter

        binding.newPlacesLayout.newPlacesList.adapter = newPlacesAdapter

    }
    private fun setupBtn(){

    }
}