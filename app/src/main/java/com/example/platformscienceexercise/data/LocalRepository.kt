package com.example.platformscienceexercise.data

import com.example.platformscienceexercise.domain.JsonUtils
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val json: JsonUtils
) {

    fun getJsonText(): String {
        return json.getDataFromJsonFile("serviceData.json")
    }
}