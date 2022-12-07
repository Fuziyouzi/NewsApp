package com.example.newsapp.presenter.tabs

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.BaseFragment
import com.example.newsapp.R
import com.example.newsapp.databinding.TopStoriesFragmentBinding
import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.presenter.pages.NewsFragment
import com.example.newsapp.presenter.base.observeEvent
import com.example.newsapp.presenter.adapter.NewsListAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopStoriesFragment : BaseFragment<TopStoriesFragmentBinding>(
    TopStoriesFragmentBinding::inflate
) {

    private val vm: TopStoriesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsListAdapter(object: NewsListAdapter.Listener {
            override fun news(news: NewsModel) {
                val bundle = bundleOf(NewsFragment.ARG_NEWS to news.map())
                findNavController().navigate(R.id.action_mainFragment_to_newsPageFragment, bundle)

            }
            override fun region(news: NewsModel) {
                Snackbar.make(view, "Done", Snackbar.LENGTH_LONG ).show()
            }
        })

        vm.showError().observeEvent(viewLifecycleOwner){
            Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        }

        vm.showList().observeEvent(viewLifecycleOwner){
            adapter.update(it)
        }


        bin.listTopStories.adapter = adapter
        bin.listTopStories.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        bin.swipeLayout.setOnRefreshListener {
            vm.getNews()
            bin.swipeLayout.isRefreshing = false
        }
    }
}