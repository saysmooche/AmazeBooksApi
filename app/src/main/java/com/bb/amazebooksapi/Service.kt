package com.bb.amazebooksapi

import com.bb.amazebooksapi.Constants.GET_URL_POSTFIX
import com.bb.amazebooksapi.Constants.VOLUMES
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("top")
    fun getRepositories(@Query("top") top: String?): Call<List<Book?>?>?

    @GET(GET_URL_POSTFIX)
    fun getRepositoriesRx(@Query(VOLUMES) volumes: String?): Observable<List<Book?>?>?
}