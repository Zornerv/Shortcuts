package com.zornerv.shortcuts

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.zornerv.shortcuts.databinding.FragmentABinding
import com.zornerv.shortcuts.util.viewBinding

class FragmentC : Fragment(R.layout.fragment_a) {

    private val binding by viewBinding(FragmentABinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        binding.title.text = "Fragment C"
        binding.button.visibility = View.GONE
    }

    companion object{
        private const val TAG = "FragmentC"
    }
}