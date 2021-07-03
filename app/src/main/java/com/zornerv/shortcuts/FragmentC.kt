package com.zornerv.shortcuts

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.zornerv.shortcuts.databinding.FragmentCBinding
import com.zornerv.shortcuts.util.showToast
import com.zornerv.shortcuts.util.viewBinding

class FragmentC : Fragment(R.layout.fragment_c) {

    private val binding by viewBinding(FragmentCBinding::bind)
    private val args by navArgs<FragmentCArgs>()

    private val shortcutManager by lazy {
        requireContext().getSystemService(ShortcutManager::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        binding.title.text = "Fragment C uuid:${args.uuid}"

        binding.createShortcutButton.setOnClickListener { createShortcut() }
        binding.checkMaxShortcutsButton.setOnClickListener { checkMaxShortcuts() }
    }

    private fun createShortcut() {
        with(binding.input.text) {
            if (!isNullOrBlank()) {
                val icon = Icon.createWithResource(requireContext(), R.drawable.ic_vaccine)
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("shortcuts://fragment_c?uuid=${toString()}")
                )
                val shortcut =
                    ShortcutInfo.Builder(requireContext(), "fragment_c_shortcut_id_${toString()}")
                        .setShortLabel("Fragment C ${toString()}")
                        .setIntent(intent)
                        .setIcon(icon)
                        .build()
                shortcutManager.addDynamicShortcuts(listOf(shortcut))
                showToast("Dynamic shortcut added!")
            } else {
                showToast("Please insert an uuid for your shortcut!")
            }
        }
    }

    private fun checkMaxShortcuts() {
        val maxShortcutsNumber = shortcutManager.maxShortcutCountPerActivity
        showToast(
            message = "At the time each launcher can have maximmum of $maxShortcutsNumber shortcuts",
            longDuration = true
        )
    }

    companion object {
        private const val TAG = "FragmentC"
    }
}