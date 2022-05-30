package com.momylaundry.ui.confirm_order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.momylaundry.databinding.ActivityConfirmOrderBinding

class ConfirmOrderActivity : AppCompatActivity() {
    private lateinit var binding:ActivityConfirmOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}