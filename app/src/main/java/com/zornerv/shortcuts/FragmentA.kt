package com.zornerv.shortcuts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zornerv.shortcuts.databinding.FragmentABinding
import com.zornerv.shortcuts.multiplebackstack.MultipleBackStackActivity
import com.zornerv.shortcuts.util.viewBinding

class FragmentA : Fragment(R.layout.fragment_a) {

    private val binding by viewBinding(FragmentABinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        binding.navigateToAButton.setOnClickListener {
            findNavController().navigate(FragmentADirections.goToB())
        }
        binding.launchMultipleBackstackButton.setOnClickListener {
            launchMultipleBackstackActivity()
        }
    }

    private fun launchMultipleBackstackActivity() {
        val intent = Intent(requireContext(), MultipleBackStackActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private const val TAG = "FragmentA"
    }
}