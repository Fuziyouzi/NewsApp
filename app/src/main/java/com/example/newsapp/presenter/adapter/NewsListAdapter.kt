package com.example.newsapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.domain.models.NewsModel

class NewsListAdapter(private val listener: Listener) :
    RecyclerView.Adapter<NewsListAdapter.TopNewsViewHolder>(), View.OnClickListener,
    AdaptersHelper {

    private val listOfNews = mutableListOf<NewsModel>()




    inner class TopNewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: NewsModel) {
            binding.titleNews.text = model.title
            binding.timeNews.text = model.publishedAt
            binding.regionNews.text = model.publisherName
            binding.root.tag = model
            binding.regionNews.tag = model
            loadImage(model.urlToImage, binding.imageNews)


        }
    }

    interface Listener {
        fun news(news: NewsModel)
        fun region(news: NewsModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(view, parent, false)

        binding.regionNews.setOnClickListener(this)
        binding.root.setOnClickListener(this)

        return TopNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) =
        holder.bind(listOfNews[position])


    override fun getItemCount(): Int = listOfNews.size

    override fun update(source: List<NewsModel>){
        val dif = DiffUtilCallback(source, listOfNews)
        val difCalculate = DiffUtil.calculateDiff(dif)
        listOfNews.clear()
        listOfNews.addAll(source)
        difCalculate.dispatchUpdatesTo(this)
    }

    override fun loadImage(resource: String?, image: ImageView) {
        if(resource?.isNotBlank() == true){
            Glide.with(image)
                .load(resource)
                .placeholder(R.drawable.sample_image)
                .error(R.drawable.sample_image)
                .into(image)
        } else {
            image.setImageResource(R.drawable.sample_image)
        }
    }

    override fun onClick(v: View) {
        val news = v.tag as NewsModel
        when (v.id) {
            R.id.regionNews -> listener.region(news)
            else -> listener.news(news)
        }
    }
}

class DiffUtilCallback(
    private val newList: List<NewsModel>,
    private val oldList: List<NewsModel>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldNews = oldList[oldItemPosition]
        val newNews = newList[newItemPosition]
        return oldNews.title == newNews.title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldNews = oldList[oldItemPosition]
        val newNews = newList[newItemPosition]
        return oldNews == newNews
    }

}
interface AdaptersHelper{

    fun update(source: List<NewsModel>)

    fun loadImage(resource: String?, image: ImageView)

}