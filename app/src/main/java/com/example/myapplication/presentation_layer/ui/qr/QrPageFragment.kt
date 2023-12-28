package com.example.myapplication.presentation_layer.ui.qr

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.dostyk.utils.fragment_utils.BindingFragment
import com.example.myapplication.databinding.FragmentQrPageBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception


class QrPageFragment : BindingFragment<FragmentQrPageBinding>(
    FragmentQrPageBinding::inflate
) {
    private lateinit var codeScanner: CodeScanner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)



        binding.scannerView.isFlashButtonVisible = false

        binding.scannerView.isAutoFocusButtonVisible = false

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupScanner()
    }

    private fun setupScanner(){
        if (allPermissionsGranted()) {
            startScanning()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

    }
    private fun startScanning() {
        codeScanner = CodeScanner(requireContext(), binding.scannerView)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS

        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false

        codeScanner.decodeCallback = DecodeCallback {
            requireActivity().runOnUiThread {
                setupNavigation()
            }
        }

        codeScanner.errorCallback = ErrorCallback {
            requireActivity().runOnUiThread {
                Toast.makeText(requireContext(), "Error: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        }

        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

        codeScanner.startPreview()
    }

    private fun allPermissionsGranted() = ContextCompat.checkSelfPermission(
        requireActivity().baseContext, Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED


    private fun setupNavigation(){
        try {

            val directions = QrPageFragmentDirections.actionBottomQrToPaymentPageFragment()
            findNavController().navigate(directions)
        }catch (e : Exception){
            Snackbar.make(requireView(), "Что то пошло не так...", Snackbar.LENGTH_SHORT).show()
        }
    }

    companion object {

        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

}

