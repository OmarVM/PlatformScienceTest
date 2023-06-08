package com.example.platformscienceexercise.mapper

import com.example.platformscienceexercise.data.model.Driver

class DriverMapper : DriverMapperContract<Driver> {

    override fun mapToDriver(driverString: String): Driver {

        var counterVowels = 0
        var counterConsonants = 0
        var counterWhiteSpace = 0
        val vowelsSet = setOf('a','e','i','o','u','A','E','I','O','U')
        var endWord = false
        val stringName: StringBuilder by lazy { StringBuilder() }
        val stringLastName: StringBuilder by lazy { StringBuilder() }

        driverString.toCharArray().forEach {

            if (it.isWhitespace()) {
                ++counterWhiteSpace
                endWord = true
            }

            if (!it.isDigit() && !it.isWhitespace() && vowelsSet.contains(it)) {
                ++counterVowels
            } else {
                ++counterConsonants
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
            vowelsNumber = counterVowels,
            consonantsNumber = counterConsonants,
            charNumber = driverString.length - counterWhiteSpace
        )
    }

    fun toDriverList(stringList: List<String>): List<Driver> {
        return stringList.map {_item ->
            mapToDriver(_item)
        }
    }
}