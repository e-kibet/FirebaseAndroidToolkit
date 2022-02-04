package com.ekibet.androidfirebaseremoteconfig.ui.splashscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    var goNext: MutableLiveData<Boolean> = MutableLiveData()

    fun setSplashTImeOut(value: Boolean){
        GlobalScope.launch {
            delay(3000)
            goNext.postValue(value)
        }
    }
}