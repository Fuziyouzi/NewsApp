package com.example.newsapp.presenter.topics

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.presenter.base.BaseFragment
import com.example.newsapp.R
import com.example.newsapp.databinding.TopicsFragmentBinding
import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.presenter.pages.NewsFragment
import com.example.newsapp.presenter.base.observeEvent
import com.example.newsapp.presenter.adapter.NewsListAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopicsFragment : BaseFragment<TopicsFragmentBinding>(
    TopicsFragmentBinding::inflate
) {

    private val vm: TopicsViewModel by viewModels()

    private val args: TopicsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsListAdapter(object : NewsListAdapter.Listener {
            override fun news(news: NewsModel) {
                val bundle = bundleOf(NewsFragment.ARG_NEWS to news.map())
                findNavController().navigate(R.id.newsPageFragment, bundle)

            }

            override fun region(news: NewsModel) {
                Snackbar.make(view, "Done", Snackbar.LENGTH_LONG).show()
            }

        })

        bin.toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }

        if (args.topic == ""){
            bin.toolbar.title = args.country
            vm.getNewsByCountry(args.country)
        }else {
            bin.toolbar.title = args.topic
            vm.getNewsByTopic(args.topic)
        }

        vm.showLoad().observeEvent(viewLifecycleOwner) {
            bin.progressBar.visibility = it
        }

        vm.showError().observeEvent(viewLifecycleOwner) {
            Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        }

        vm.showList().observeEvent(viewLifecycleOwner) {
            adapter.update(it)
        }
        bin.listOfNews.adapter = adapter
        bin.listOfNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}