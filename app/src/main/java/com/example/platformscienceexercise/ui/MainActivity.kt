package com.example.platformscienceexercise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.platformscienceexercise.R
import com.example.platformscienceexercise.domain.usecase.FindingMaxSuitabilityUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var maxSuitabilityUseCase: FindingMaxSuitabilityUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG", "JSON TEXT -> ${maxSuitabilityUseCase()}")
    }
}