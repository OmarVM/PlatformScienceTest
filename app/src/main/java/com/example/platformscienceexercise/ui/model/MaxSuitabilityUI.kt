package com.example.platformscienceexercise.ui.model

import com.example.platformscienceexercise.data.model.Driver
import com.example.platformscienceexercise.data.model.Shipment

data class MaxSuitabilityUI(
    val driver: Driver,
    val shipment: Shipment,
    val maxSuitability: Double
)
