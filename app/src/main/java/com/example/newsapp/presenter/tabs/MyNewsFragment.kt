package com.example.newsapp.presenter.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.presenter.base.BaseFragment
import com.example.newsapp.R
import com.example.newsapp.core.visibility
import com.example.newsapp.databinding.MyNewsFragmetBinding
import com.example.newsapp.domain.models.NewsModel
import com.example.newsapp.presenter.adapter.NewsListAdapter
import com.example.newsapp.presenter.base.observeEvent
import com.example.newsapp.presenter.models.ListOfCountry
import com.example.newsapp.presenter.models.ListOfCountryImpl
import com.example.newsapp.presenter.pages.NewsFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyNewsFragment : BaseFragment<MyNewsFragmetBinding>(
    MyNewsFragmetBinding::inflate
) {
    private val vm: MyNewsViewModel by viewModels()

    private val listOfCountry: ListOfCountry = ListOfCountryImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsListAdapter(object : NewsListAdapter.Listener {
            override fun news(news: NewsModel) {
                val bundle = bundleOf(NewsFragment.ARG_NEWS to news.map())
                findNavController().navigate(R.id.action_mainFragment_to_newsPageFragment, bundle)
            }

            override fun region(news: NewsModel) {
                snackBar(view, "Done")
            }

        })
        vm.getCountry()

        vm.showList().observeEvent(viewLifecycleOwner) {
            adapter.update(it)
        }
        bin.listNews.adapter = adapter
        bin.listNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        vm.showError().observeEvent(viewLifecycleOwner) {
            snackBar(view, it)
        }
        vm.showSuccess().observeEvent(viewLifecycleOwner) {
            if (it != "no_country") {
                vm.getUserNews()
                if (bin.userCountry.text == "") {
                    bin.userCountry.text = listOfCountry.getNameOfCountry(it)
                }
            } else {
                bin.userCountry.visibility = View.GONE
                bin.editCountry.visibility = View.GONE
                bin.listNews.visibility = View.GONE
                bin.chooseLayout.visibility = View.VISIBLE
            }
        }


        bin.btnChoose.setOnClickListener {
            dialog()
        }
        bin.editCountry.setOnClickListener {
            dialog()
        }
        bin.swipeLayout.setOnRefreshListener {
            vm.getUserNews()
            bin.swipeLayout.isRefreshing = false
        }
    }

    private fun dialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.choose_country)
            .setPositiveButton(R.string.ok) { _, _ ->
                val country = listOfCountry.getCodeOfCountry(bin.userCountry.text.toString())
                vm.updateUserCountry(country)
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }
            .setSingleChoiceItems(listOfCountry.getList(), 1) { _, which ->
                bin.userCountry.text = listOfCountry.getList()[which]
            }
            .show()
    }


}