package com.example.platformscienceexercise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.platformscienceexercise.databinding.ActivityMainBinding
import com.example.platformscienceexercise.domain.viewmodel.MainViewModel
import com.example.platformscienceexercise.ui.model.DataHandler
import com.example.platformscienceexercise.ui.model.MaxSuitabilityUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), DriversAdapter.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.listMaxSuitability.observe(this) { _info ->
            when(_info) {
                is DataHandler.LOADING -> {}
                is DataHandler.SUCCESS -> {
                    val mAdapter = _info.data?.let { DriversAdapter(it) }
                    mAdapter?.setListener(this)
                    binding.driversRv.adapter = mAdapter
                }
                is DataHandler.ERROR -> {}
            }
        }

        viewModel.getListItems()
    }

    override fun onClick(item: MaxSuitabilityUI) {
        Log.d("TAG", "Content: ${item.shipment.address}")
    }
}