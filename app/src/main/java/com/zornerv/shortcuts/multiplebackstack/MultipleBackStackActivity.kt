package com.zornerv.shortcuts.multiplebackstack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zornerv.shortcuts.databinding.ActivityMultipleBackstackBinding
import com.zornerv.shortcuts.util.viewBinding

class MultipleBackStackActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMultipleBackstackBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}