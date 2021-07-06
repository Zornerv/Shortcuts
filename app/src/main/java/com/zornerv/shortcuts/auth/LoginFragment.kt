package com.zornerv.shortcuts.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zornerv.shortcuts.R
import com.zornerv.shortcuts.databinding.FragmentLoginBinding
import com.zornerv.shortcuts.util.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}