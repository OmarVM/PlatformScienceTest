package com.example.platformscienceexercise.mapper

interface ShipmentMapperContract<Shipment> {

    fun mapToShipment(shipmentString: String): Shipment
}