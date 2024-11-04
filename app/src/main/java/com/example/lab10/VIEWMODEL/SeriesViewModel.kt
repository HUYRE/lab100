package com.example.lab10.VIEWMODEL


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.lab10.data.SerieModel
import com.example.lab10.repository.SerieRepository

class SeriesViewModel(private val repository: SerieRepository) : ViewModel() {
    val seriesList = MutableLiveData<List<SerieModel>>()
    val serieDetail = MutableLiveData<SerieModel?>()

    fun fetchSeries() {
        viewModelScope.launch {
            try {
                seriesList.value = repository.getSeries()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addSerie(serie: SerieModel) {
        viewModelScope.launch {
            try {
                repository.createSerie(serie)
                fetchSeries()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateSerie(id: Int, serie: SerieModel) {
        viewModelScope.launch {
            try {
                repository.updateSerie(id, serie)
                fetchSeries()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteSerie(id: Int) {
        viewModelScope.launch {
            try {
                repository.deleteSerie(id)
                fetchSeries()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchSerieDetail(id: Int) {
        viewModelScope.launch {
            try {
                serieDetail.value = repository.getSerieById(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
