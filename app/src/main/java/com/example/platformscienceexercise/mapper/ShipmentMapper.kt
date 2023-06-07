package com.example.platformscienceexercise.mapper

import com.example.platformscienceexercise.data.model.Shipment

class ShipmentMapper: ShipmentMapperContract<Shipment> {

    override fun mapToShipment(shipmentString: String): Shipment {

        var counterWhiteSpace = 0
        var endWord = false
        val stringZipCode: StringBuilder by lazy { StringBuilder() }
        val stringAddress: StringBuilder by lazy { StringBuilder() }

        shipmentString.toCharArray().forEach {

            if (it.isWhitespace()) {
                ++counterWhiteSpace
                endWord = true
            }

            when(endWord) {
                true -> {
                    stringAddress.append(it)
                }
                false -> {
                    stringZipCode.append(it)
                }
            }
        }

        return Shipment(
            zipCode = stringZipCode.toString().toInt(),
            address = stringAddress.toString(),
            charNumber = shipmentString.length - counterWhiteSpace
        )
    }

    fun toShipmentList(stringList: List<String>) : List<Shipment> {
        return stringList.map { _item ->
            mapToShipment(_item)
        }
    }
}