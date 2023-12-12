package com.example.dostyk.utils.activity_utils

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <VB : ViewBinding>(
    private val inflate: (LayoutInflater) -> VB
) : AppCompatActivity()
{

    private var _binding: VB? = null
    val binding: VB get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflate.invoke(layoutInflater)

        setContentView(binding.root)

    }
}