package com.example.platformscienceexercise.di

import android.content.Context
import com.example.platformscienceexercise.data.LocalRepository
import com.example.platformscienceexercise.domain.JsonUtils
import com.example.platformscienceexercise.mapper.DriverMapper
import com.example.platformscienceexercise.mapper.ShipmentMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun getJsonContent(@ApplicationContext context: Context): JsonUtils {
        return JsonUtils(context)
    }

    @Singleton
    @Provides
    fun getLocalRepository(
        jsonUtils: JsonUtils,
        driverMapper: DriverMapper,
        shipmentMapper: ShipmentMapper
    ): LocalRepository {
        return LocalRepository(
            jsonUtils,
            driverMapper,
            shipmentMapper
        )
    }

    @Provides
    fun getDriverMapper() = DriverMapper()

    @Provides
    fun getShipmentMapper() = ShipmentMapper()
}