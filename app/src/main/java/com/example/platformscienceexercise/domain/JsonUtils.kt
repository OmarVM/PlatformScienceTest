package com.example.platformscienceexercise.domain

import android.content.Context
import java.io.IOException
import javax.inject.Inject

class JsonUtils @Inject constructor(
    private val context: Context,
) {

    fun getDataFromJsonFile(fileName: String): String {
        var jsonString: String = ""

        try {
            jsonString = context
                .assets
                .open(fileName)
                .bufferedReader()
                .use {
                it.readText()
            }
        } catch (exception: IOException) {
            exception.printStackTrace()
        }
        return jsonString
    }
}