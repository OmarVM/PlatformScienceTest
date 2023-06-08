package com.example.platformscienceexercise.ui.model

sealed class DataHandler<T> (
    val progress: Int? = 0,
    val data: T? = null,
    val message: String? = null,
    val codeError: Int? = null
    ) {
    class SUCCESS<T>(data: T) : DataHandler<T>(data = data)
    class ERROR<T>(data: T? = null, message: String? = null, codeError: Int? = null) :
        DataHandler<T>(data = data, message = message, codeError = codeError)

    class LOADING<T>(progress: Int?) : DataHandler<T>(progress = progress)
}
