package com.example.platformscienceexercise.mapper

interface DriverMapperContract<Driver> {

    fun mapToDriver(driverString: String): Driver
}