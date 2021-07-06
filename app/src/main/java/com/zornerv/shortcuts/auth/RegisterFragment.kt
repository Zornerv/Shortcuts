package com.zornerv.shortcuts.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zornerv.shortcuts.R
import com.zornerv.shortcuts.databinding.FragmentRegisterBinding
import com.zornerv.shortcuts.util.viewBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}