package com.zornerv.shortcuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zornerv.shortcuts.databinding.ActivityMainBinding
import com.zornerv.shortcuts.databinding.ActivityMainBinding.inflate
import com.zornerv.shortcuts.util.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}