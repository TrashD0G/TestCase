package com.artem.testcase.retrofit

import com.artem.testcase.POJO.RegresPOJO
import com.artem.testcase.di.DaggerAppComponent
import retrofit2.Response
import javax.inject.Inject

class ApiRequest {

  @Inject
   lateinit var api:RegresApi

   init {
       DaggerAppComponent.create().injectApiRequest(this)
   }

    suspend fun getReguest(): Response<RegresPOJO> {
        return api.getUsers()
    }
}