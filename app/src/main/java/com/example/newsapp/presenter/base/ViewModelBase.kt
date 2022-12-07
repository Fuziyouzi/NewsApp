package com.example.newsapp.presenter.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import javax.inject.Inject

open class ViewModelBase @Inject constructor() :
    ViewModel() {

}

interface ObserveViewModel {

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>)

    fun observeState(owner: LifecycleOwner, observer: Observer<Boolean>)
}
