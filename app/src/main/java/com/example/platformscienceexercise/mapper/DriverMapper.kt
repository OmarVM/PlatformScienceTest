package com.example.platformscienceexercise.mapper

import com.example.platformscienceexercise.data.model.Driver

class DriverMapper : DriverMapperContract<Driver> {

    override fun mapToDriver(driverString: String): Driver {

        var counterWhiteSpace = 0
        var endWord = false
        val stringName: StringBuilder by lazy { StringBuilder() }
        val stringLastName: StringBuilder by lazy { StringBuilder() }

        driverString.toCharArray().forEach {

            if (it.isWhitespace()) {
                ++counterWhiteSpace
                endWord = true
            }

            when(endWord) {
                true -> {
                    stringName.append(it)
                }
                false -> {
                    stringLastName.append(it)
                }
            }
        }

        return Driver(
            name = stringName.toString(),
            lastName = stringLastName.toString(),
            charNumber = driverString.length - counterWhiteSpace
        )
    }

    fun toDriverList(stringList: List<String>): List<Driver> {
        return stringList.map {_item ->
            mapToDriver(_item)
        }
    }
}