package com.example.platformscienceexercise.domain.usecase

import com.example.platformscienceexercise.data.LocalRepository
import com.example.platformscienceexercise.data.model.Driver
import com.example.platformscienceexercise.data.model.Shipment
import com.example.platformscienceexercise.ui.model.MaxSuitabilityUI
import javax.inject.Inject

class FindingMaxSuitabilityUseCase @Inject constructor(
   private val localRepository: LocalRepository
) {

    operator fun invoke(): ArrayList<MaxSuitabilityUI> {
        val data = localRepository.getInfo()
        val listDrivers: MutableList<Driver> = data.first as ArrayList
        val listShipments: MutableList<Shipment> = data.second as ArrayList
        val result: ArrayList<MaxSuitabilityUI> = arrayListOf()

        listDrivers.forEach { _driver ->
            var maxSuitability = 0.0
            var currentDriver: Driver = _driver
            var currentShipment = Shipment(0, "xxxx", 0)

            for (shipment in listShipments) {
                var currentSuitability: Double = 0.0
                currentSuitability = if (shipment.charNumber % 2 == 0) {
                    destinationEven(_driver)
                } else {
                    destinationOdd(_driver)
                }

                if (currentSuitability > maxSuitability) {
                    maxSuitability = currentSuitability
                    currentDriver = _driver
                    currentShipment = shipment
                }

                val driverFactors = getFactorsOfNumber(_driver.charNumber)
                val shipmentFactors = getFactorsOfNumber(shipment.charNumber)

                if (areCommonFactors(driverFactors, shipmentFactors)) {
                    val fiftyPercent = maxSuitability / 2
                    maxSuitability += fiftyPercent
                }
            }

            result.add(MaxSuitabilityUI(
                currentDriver,
                currentShipment,
                maxSuitability
            ))

            listShipments.remove(currentShipment)
        }

        return result
    }

    private fun destinationEven(driver: Driver): Double {
       return driver.vowelsNumber * 1.5
    }

    private fun destinationOdd(driver: Driver): Double {
        return (driver.consonantsNumber * 1).toDouble()
    }

    private fun getFactorsOfNumber(stringLength: Int): Set<Int> {
        val mSetFactors = mutableSetOf<Int>()
        for (i in 2..stringLength) {
            if (stringLength % i == 0) {
                mSetFactors.add(i)
            }
        }
        return mSetFactors
    }

    private fun areCommonFactors(driverSet: Set<Int>, shipmentSet: Set<Int>): Boolean {

        driverSet.forEach {
            if (shipmentSet.contains(it)) {
                return@forEach
            }
        }
        return false
    }
}