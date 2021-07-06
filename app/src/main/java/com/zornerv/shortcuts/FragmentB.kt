package com.zornerv.shortcuts

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zornerv.shortcuts.databinding.FragmentBBinding
import com.zornerv.shortcuts.util.viewBinding

class FragmentB : Fragment(R.layout.fragment_b) {

    private val binding by viewBinding(FragmentBBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        binding.button.setOnClickListener {
            findNavController().navigate(FragmentBDirections.goToC())
        }

        binding.navigateToAuthButton.setOnClickListener {
//            findNavController().navigate(R.id.auth)
//            findNavController().navigate(Uri.parse("shortcutsAuth://auth_register"))
            findNavController().navigate(Uri.parse(getString(R.string.deeplink_auth_register)))
        }
    }

    companion object {
        private const val TAG = "FragmentB"
    }

}