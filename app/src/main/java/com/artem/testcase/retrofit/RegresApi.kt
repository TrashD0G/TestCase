package com.artem.testcase.retrofit

import com.artem.testcase.POJO.RegresPOJO
import retrofit2.Response
import retrofit2.http.GET

interface RegresApi {

    @GET("users")
    suspend fun getUsers() : Response<RegresPOJO>

}