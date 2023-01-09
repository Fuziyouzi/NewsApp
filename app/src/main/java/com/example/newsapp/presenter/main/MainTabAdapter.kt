package com.example.newsapp.presenter.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.presenter.tabs.MyNewsFragment
import com.example.newsapp.presenter.tabs.PopularFragment
import com.example.newsapp.presenter.tabs.TopStoriesFragment
import com.example.newsapp.presenter.tabs.FavoriteNewsFragment

class MainTabAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TopStoriesFragment()
            1 -> PopularFragment()
            2 -> MyNewsFragment()
            3 -> FavoriteNewsFragment()
            else -> throw IllegalStateException()
        }

    }
}