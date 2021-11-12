package com.example.corrutinasflow.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corrutinasflow.data.domain.CalculateFibonacciUserCase
import com.example.corrutinasflow.data.domain.SportListUserCase
import com.example.corrutinasflow.data.domain.WeatherUserCase
import com.example.corrutinasflow.data.model.SportEntity
import com.example.corrutinasflow.data.model.WeatherEntityResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherUserCase: WeatherUserCase,
    private val sportUserCase: SportListUserCase
) : ViewModel() {

    var mldWeather = MutableLiveData<WeatherEntityResponse>()
    var mldSport = MutableLiveData<List<SportEntity>>()

    fun getWeatherViewModel() {
        viewModelScope.launch {
            val response = weatherUserCase.getWeatherUserCase()
            this@HomeViewModel.mldWeather.postValue(response)
        }
    }

    fun getSportListViewModel(){
        viewModelScope.launch {
            val response = sportUserCase.getSportListUserCase()
            this@HomeViewModel.mldSport.postValue(response)
        }
    }
}