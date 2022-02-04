package com.ekibet.androidfirebaseremoteconfig.ui.pay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PayViewModel: ViewModel() {
    var amount: MutableLiveData<Int> = MutableLiveData()
}