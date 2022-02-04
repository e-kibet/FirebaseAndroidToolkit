package com.ekibet.androidfirebaseremoteconfig.ui.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ekibet.androidfirebaseremoteconfig.R
import com.ekibet.androidfirebaseremoteconfig.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var splashBinding: FragmentSplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        splashBinding  = FragmentSplashBinding.inflate(inflater)

        initViewModel()
        return splashBinding.root
    }

    private fun initViewModel(){
        splashViewModel.goNext.observe(viewLifecycleOwner, {
            if(it){
                findNavController().navigate(R.id.loginFragment)
            }
        })
        splashViewModel.setSplashTImeOut(true)
    }
}