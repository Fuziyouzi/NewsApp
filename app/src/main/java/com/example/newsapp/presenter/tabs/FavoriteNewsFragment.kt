package com.example.newsapp.presenter.tabs

import android.os.Bundle
import android.view.View
import com.example.newsapp.databinding.FavoriteNewsFragmentBinding
import com.example.newsapp.presenter.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteNewsFragment: BaseFragment<FavoriteNewsFragmentBinding>(
    FavoriteNewsFragmentBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}