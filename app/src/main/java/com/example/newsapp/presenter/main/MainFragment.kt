package com.example.newsapp.presenter.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.core.view.GravityCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.presenter.base.BaseFragment
import com.example.newsapp.R
import com.example.newsapp.core.visibility
import com.example.newsapp.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding>(
    MainFragmentBinding::inflate
) {

    private val vm: MainViewModelFragment by viewModels()
    private val tabList = arrayOf(
        R.string.top_stories,
        R.string.popular,
        R.string.my_news,
        R.string.favorite
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appBarConf = AppBarConfiguration(findNavController().graph, bin.drawerLayout)

        bin.toolBar.setupWithNavController(findNavController(), appBarConf)
        bin.navView.setupWithNavController(findNavController())

        bin.toolBar.setNavigationOnClickListener {
            bin.drawerLayout.openDrawer(GravityCompat.START)
        }


        val header = bin.navView.getHeaderView(0)
        header.findViewById<FrameLayout>(R.id.topics).setOnClickListener {
            header.findViewById<LinearLayout>(R.id.topicsList).visibility()
        }
        header.findViewById<FrameLayout>(R.id.worldNews).setOnClickListener {
            header.findViewById<LinearLayout>(R.id.worldList).visibility()
        }

        navToTopics(header, R.id.us, "", "Us")
        navToTopics(header, R.id.jp, "", "Jp")
        navToTopics(header, R.id.ca, "", "Ca")
        navToTopics(header, R.id.ua, "", "Ua")
        navToTopics(header, R.id.pl, "", "Pl")

        navToTopics(header, R.id.business, "Business", "")
        navToTopics(header, R.id.tech, "Technology", "")
        navToTopics(header, R.id.health, "Health", "")
        navToTopics(header, R.id.science, " Science", "")
        navToTopics(header, R.id.sport, "Sports", "")
        navToTopics(header, R.id.entertainment, "Entertainment", "")



        bin.viewPager.adapter = MainTabAdapter(this)
        TabLayoutMediator(bin.tabLayout, bin.viewPager) { tab, pos ->
            tab.setText(tabList[pos])
        }.attach()


        bin.toolBar.setOnMenuItemClickListener { menu ->
            when (menu.itemId) {
                R.id.settings -> {
                    findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
                    true
                }
                R.id.privacySettings -> {
                    findNavController().navigate(R.id.action_mainFragment_to_privacySettingsFragment)
                    true
                }
                R.id.help -> {
                    findNavController().navigate(R.id.action_mainFragment_to_helpFragment)
                    true
                }
                R.id.contactUs -> {
                    findNavController().navigate(R.id.action_mainFragment_to_contactUs2)
                    true
                }
                else -> false
            }
        }
    }

    private fun navToTopics(header: View, @IdRes res: Int, topics: String, country: String) {
        header.findViewById<TextView>(res).setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToTopicsFragment(topics, country)
            findNavController().navigate(action)
        }
    }
}