package com.example.platformscienceexercise.data

import com.example.platformscienceexercise.data.model.Driver
import com.example.platformscienceexercise.data.model.ServiceResponse
import com.example.platformscienceexercise.data.model.Shipment
import com.example.platformscienceexercise.domain.JsonUtils
import com.example.platformscienceexercise.mapper.DriverMapper
import com.example.platformscienceexercise.mapper.ShipmentMapper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val json: JsonUtils,
    private val mapperDriver: DriverMapper,
    private val mapperShipment: ShipmentMapper
) {

    fun getInfo(): Pair<List<Driver>?, List<Shipment>?> {
        val jsonString = json.getDataFromJsonFile(Constants.NAME_SERVICE_JSON_FILE)
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<ServiceResponse> = moshi.adapter(ServiceResponse::class.java)

        val data = jsonAdapter.fromJson(jsonString)

        val driversList = data?.drivers?.let { mapperDriver.toDriverList(it) }
        val shipmentList = data?.shipments?.let { mapperShipment.toShipmentList(it) }
        return Pair(driversList, shipmentList)
    }
}

object Constants {
    const val NAME_SERVICE_JSON_FILE = "serviceData.json"
}