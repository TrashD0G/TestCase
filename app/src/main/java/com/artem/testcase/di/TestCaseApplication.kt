package com.artem.testcase.di

import android.app.Application

class TestCaseApplication : Application() {

    lateinit var applicationAppComponent: AppComponent
        private set


    override fun onCreate() {
        super.onCreate()
        applicationAppComponent = DaggerAppComponent.create()
    }
}