package com.artem.testcase.di

import com.artem.testcase.retrofit.ApiRequest
import com.artem.testcase.retrofit.RegresApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class UsersListProvides {

    @Provides
    fun providesGson(): Gson = GsonBuilder().create()


    @Singleton
    @Provides
    fun providesRetrofit(gson: Gson): RegresApi {
        return Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RegresApi::class.java)
    }


    @Provides
    fun providesApiRequest(): ApiRequest {
        return ApiRequest()
    }
}