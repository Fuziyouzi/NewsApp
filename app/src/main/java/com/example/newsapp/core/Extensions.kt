package com.example.newsapp.core

import android.view.View
import com.example.newsapp.data.models.NewsHeadlines



fun NewsHeadlines.editName(name: String?): String? {
    if (name != null) {
        if (name.startsWith('W')) {
            return name.replaceBefore('.', "").removePrefix(".")
        }
    }
    return name?.replaceAfter('.', "")?.removeSuffix(".")
}

fun NewsHeadlines.editTime(time: String?): String? {
    return time?.removeRange(0, 11)?.removeRange(5, 9)

}

fun View.visibility() {
    if (this.visibility == View.VISIBLE) this.visibility = View.GONE else this.visibility =
        View.VISIBLE
}




