package com.ekibet.androidfirebaseremoteconfig.base
import android.annotation.SuppressLint
import com.ekibet.androidfirebaseremoteconfig.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import timber.log.Timber


/**
 * singleton object
 */
object SingletonRemoteConfig {

    @SuppressLint("StaticFieldLeak")
    private lateinit var remoteConfig: FirebaseRemoteConfig

    private const val SHOW_REQUEST_TOKEN_BUTTON = "show_request_token_buton"
    private const val MAX_AMOUNT = "max_amount"
    private const val MIN_AMOUNT = "min_amount"

    fun init() {
        remoteConfig = fetchDetails()
    }
    private fun fetchDetails () : FirebaseRemoteConfig{
        val internalRemoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings: FirebaseRemoteConfigSettings =  remoteConfigSettings {
            minimumFetchIntervalInSeconds= 0 // u will wait for the remote changes for 10 seconds
        }
        internalRemoteConfig.apply {
            setConfigSettingsAsync(configSettings)
            setDefaultsAsync(R.xml.defaultc_config)
            fetchAndActivate().addOnCompleteListener {
                Timber.d("Fetched")
            }
        }
        return internalRemoteConfig
    }

    fun displayRequestMoneyLink(): Boolean = remoteConfig.getBoolean(SHOW_REQUEST_TOKEN_BUTTON)
    fun checkMinAmount(): String = remoteConfig.getString(MIN_AMOUNT)
    fun checkMaxAmount(): String = remoteConfig.getString(MAX_AMOUNT)
}