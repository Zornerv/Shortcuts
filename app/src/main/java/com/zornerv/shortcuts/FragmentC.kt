package com.zornerv.shortcuts

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
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
        binding.createPinnedShortcutButton.setOnClickListener { createPinnedShortcut() }
    }

    private fun createShortcut() {
        with(binding.input.text) {
            if (!isNullOrBlank()) {
                val shortcut = prepareShortcutInfo()
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

    private fun createPinnedShortcut() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            showToast("Pinned Shortcuts are not supported on sdk below 26")
            return
        }

        if (shortcutManager.isRequestPinShortcutSupported) {
            val pinShortcutInfo = prepareShortcutInfo()
            val pinnedShortcutCallbackIntent =
                shortcutManager.createShortcutResultIntent(pinShortcutInfo)

            val successCallback = PendingIntent.getBroadcast(
                requireContext(),
                RC_PINNED_SHORTCUT,
                pinnedShortcutCallbackIntent,
                PendingIntent.FLAG_IMMUTABLE
            )

            shortcutManager.requestPinShortcut(pinShortcutInfo, successCallback.intentSender)
        } else {
            showToast(
                message = "Pinned shortcuts are not supported by the default launcher",
                longDuration = true
            )
        }
    }

    private fun prepareShortcutInfo(): ShortcutInfo {
        val uuidArgument = binding.input.text.toString()
        val id = "fragment_c_$uuidArgument"
        val icon = Icon.createWithResource(requireContext(), R.drawable.ic_vaccine)
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("shortcuts://fragment_c?uuid=$uuidArgument")
        )

        return ShortcutInfo.Builder(requireContext(), id)
            .setIntent(intent)
            .setShortLabel("Fragment C ${binding.input.text}")
            .setIcon(icon)
            .build()
    }

    companion object {
        private const val TAG = "FragmentC"
        private const val RC_PINNED_SHORTCUT = 34
    }
}