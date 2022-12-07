package com.example.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val inflaterB: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var binding: VB? = null
    protected val bin get() = checkNotNull(binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflaterB.invoke(inflater, container, false)

        return bin.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}