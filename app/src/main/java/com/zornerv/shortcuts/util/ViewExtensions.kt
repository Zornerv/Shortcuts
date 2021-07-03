package com.zornerv.shortcuts.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String, longDuration: Boolean = false) {
    val duration = if (longDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    Toast.makeText(requireContext(), message, duration).show()
}