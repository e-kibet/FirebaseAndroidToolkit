package com.ekibet.androidfirebaseremoteconfig.ui.pay

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ekibet.androidfirebaseremoteconfig.base.SingletonRemoteConfig
import com.ekibet.androidfirebaseremoteconfig.databinding.FragmentPayBinding

class PayFragment : Fragment() {
    lateinit var fragmentPayBinding: FragmentPayBinding
    private val payViewModel: PayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPayBinding = FragmentPayBinding.inflate(inflater)



        if(SingletonRemoteConfig.displayRequestMoneyLink()){
            fragmentPayBinding.tvRequestToken.visibility = View.VISIBLE
        }else{
            fragmentPayBinding.tvRequestToken.visibility = View.GONE
        }

        fragmentPayBinding.etAmount.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               if(p0?.isNotEmpty() == true){
                   fragmentPayBinding.txAmount.error = null
                   if(fragmentPayBinding.etAmount.text.toString().toInt() > SingletonRemoteConfig.checkMinAmount().toInt() && fragmentPayBinding.etAmount.text.toString().toInt() < SingletonRemoteConfig.checkMaxAmount().toInt()){ // THIS IS NOT ALLOWED AT ALL
                       payViewModel.amount.postValue(fragmentPayBinding.etAmount.text.toString().toInt())
                       fragmentPayBinding.btnSubmit.isEnabled = true
                   }else{
                       fragmentPayBinding.btnSubmit.isEnabled= false
                       fragmentPayBinding.txAmount.error = "Please enter a valid amount"
                   }
               }else{
                   fragmentPayBinding.btnSubmit.isEnabled = false
                   fragmentPayBinding.txAmount.error = "Amount is required"
               }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        fragmentPayBinding.etPhoneNumber.addTextChangedListener {object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // check the regex of the msisdn
                if(p0.toString().matches("^(?:254|\\+254|0)?(7(?:(?:[129][0–9])|(?:0[0–8])|(4[0–1]))[0–9]{6})$".toRegex())){
                    //invalid msisdn
                }else{
                    // this is the valid msisdn
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        }}


        // make the api call
        fragmentPayBinding.btnSubmit.setOnClickListener {
            Toast.makeText(requireContext(), "amount: ${payViewModel.amount.value.toString()}", Toast.LENGTH_SHORT).show()
        }

        return fragmentPayBinding.root
    }
}