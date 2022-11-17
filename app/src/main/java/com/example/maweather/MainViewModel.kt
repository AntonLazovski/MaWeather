package com.example.maweather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maweather.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()

}