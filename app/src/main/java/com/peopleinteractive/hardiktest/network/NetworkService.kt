package com.peopleinteractive.hardiktest.network

import com.peopleinteractive.hardiktest.model.User
import com.peopleinteractive.hardiktest.network.NetworkApiConstant.BASE_URL
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET(BASE_URL)
    fun getUser(@Query("results") results: String): Observable<User>
}