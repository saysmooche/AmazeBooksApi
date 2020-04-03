package com.bb.amazebooksapi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val retrofitInstance: RetrofitInstance
    fun getBookListRx(volume: String?): Observable<List<Book>> {
        return retrofitInstance
                .getRepositoriesRx(volume)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    init {
        retrofitInstance = RetrofitInstance()
    }
}