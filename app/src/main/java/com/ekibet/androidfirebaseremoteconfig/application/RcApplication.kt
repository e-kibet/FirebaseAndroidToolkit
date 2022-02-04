package com.ekibet.androidfirebaseremoteconfig.application

import android.app.Application
import com.ekibet.androidfirebaseremoteconfig.base.SingletonRemoteConfig

class RcApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SingletonRemoteConfig.init()
    }

}