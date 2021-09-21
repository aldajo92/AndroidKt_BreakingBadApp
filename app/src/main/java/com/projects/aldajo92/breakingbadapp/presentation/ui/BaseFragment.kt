package com.projects.aldajo92.breakingbadapp.presentation.ui

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun showToastMessage(message: String?) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    fun showLoader(showLoader: Boolean) {
        (requireActivity() as MainActivity).showProgressBar(showLoader)
    }

    fun showToolbarTitle(@StringRes stringId: Int, enableToolbar: Boolean) {
        showToolbarTitle(
            requireContext().getString(stringId),
            enableToolbar
        )
    }

    fun showToolbarTitle(title: String, enableToolbar: Boolean) {
        (requireActivity() as MainActivity).showToolbarTitle(
            title,
            enableToolbar
        )
    }
}
