package com.example.newsapp.data.core

import android.database.sqlite.SQLiteException
import com.example.newsapp.domain.models.StorageException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

suspend fun <T> handleStorageRequest(dispatcher: CoroutineDispatcher, block: suspend CoroutineScope.() -> T): T{
    try {
        return withContext(dispatcher, block)
    }catch (e: SQLiteException){
        throw StorageException()
    }
}