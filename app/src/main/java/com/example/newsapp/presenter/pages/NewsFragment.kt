package com.example.newsapp.presenter.pages

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.newsapp.presenter.base.BaseFragment
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsFragmentBinding
import com.example.newsapp.presenter.base.ImageLoader
import com.example.newsapp.presenter.base.ImageLoaderImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<NewsFragmentBinding>(
    NewsFragmentBinding::inflate
) {



    private val loadImage: ImageLoader = ImageLoaderImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bin.toolbarPageNews.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        val news = requireArguments().getStringArray(ARG_NEWS)

        bin.author.text = news!![0]
        bin.mainText.text = news[2]
        bin.timePublished.text = news[3]
        bin.title.text = news[5]
        bin.resource.text = news[4]
        loadImage.load(news[7], bin.imageNews)

        bin.link.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
            Uri.parse(news[6]))
            startActivity(intent)
        }



    }

    companion object {
        const val ARG_NEWS = "news"

    }
}

