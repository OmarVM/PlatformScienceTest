package com.example.platformscienceexercise.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platformscienceexercise.domain.usecase.FindingMaxSuitabilityUseCase
import com.example.platformscienceexercise.ui.model.DataHandler
import com.example.platformscienceexercise.ui.model.MaxSuitabilityUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val maxSuitabilityUseCase: FindingMaxSuitabilityUseCase
): ViewModel() {

    private val _listMaxSuitability = MutableLiveData<DataHandler<List<MaxSuitabilityUI>>>()
    val listMaxSuitability: LiveData<DataHandler<List<MaxSuitabilityUI>>> = _listMaxSuitability

    fun getListItems() {
        viewModelScope.launch {
            val result = maxSuitabilityUseCase()

            if (result.isNotEmpty()) {
                _listMaxSuitability.postValue(DataHandler.SUCCESS(result))
            } else {
                _listMaxSuitability.postValue(DataHandler.ERROR())
            }
        }
    }
}