package com.peopleinteractive.hardiktest.app

import android.app.Application

class App : Application() {

    companion object {

        lateinit var mInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }
}