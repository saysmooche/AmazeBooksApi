package com.bb.amazebooksapi

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private val service:Service
    private val client:OkHttpClient
    init{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        service = createService(RetrofitInstance())
    }
    private fun RetrofitInstance():Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    private fun createService(retrofitInstance:Retrofit):Service {
        return retrofitInstance.create(Service::class.java)
    }
    fun getRepositories(top:String): Call<List<Book?>?>? {
        return service.getRepositories(top)
    }
    fun getRepositoriesRx(category:String): Observable<List<Book?>?>? {
        return service.getRepositoriesRx(category)
    }
}