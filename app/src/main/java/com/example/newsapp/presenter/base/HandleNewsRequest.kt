package com.example.newsapp.presenter.base

import android.view.View
import androidx.lifecycle.LiveData
import com.example.newsapp.core.Dispatcher
import com.example.newsapp.domain.models.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

interface HandleNewsRequest {

        fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> NewsResult<List<NewsModel>, String>
    )



    fun showError(): LiveData<Event<String>>

    fun loading(): LiveData<Event<Int>>

    fun showList(): LiveData<Event<List<NewsModel>>>
}

class HandleNewsRequestImpl @Inject constructor(
    private val dispatcher: Dispatcher
) : HandleNewsRequest {
    private val error: MutableLiveEvent<String> = MutableLiveEvent()

    private val list: MutableLiveEvent<List<NewsModel>> = MutableLiveEvent()

    private val load: MutableLiveEvent<Int> = MutableLiveEvent()


    override fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> NewsResult<List<NewsModel>, String>
    ) {
        coroutineScope.launch(dispatcher.main) {
            when (block.invoke()) {
                    is NewsResult.Success -> list.publishEvent(((block.invoke() as NewsResult.Success<List<NewsModel>>).value))
                    is NewsResult.Failure -> error.publishEvent((block.invoke() as NewsResult.Failure<String>).error)
                }
        }
        load.publishEvent(View.GONE)
    }

    override fun showError() = error.share()

    override fun loading() = load.share()

    override fun showList() = list.share()

}