package com.example.lab10.repository

import com.example.lab10.data.SerieApiService
import com.example.lab10.data.SerieModel

class SerieRepository(private val apiService: SerieApiService) {

    // Método para obtener la lista de series
    suspend fun getSeries(): List<SerieModel> {
        return apiService.selectSeries()
    }

    // Método para obtener una serie específica por ID
    suspend fun getSerieById(id: Int): SerieModel? {
        val response = apiService.selectSerie(id.toString())
        return if (response.isSuccessful) response.body() else null
    }

    // Método para crear una nueva serie
    suspend fun createSerie(serie: SerieModel) {
        apiService.insertSerie(serie)
    }

    // Método para actualizar una serie existente
    suspend fun updateSerie(id: Int, serie: SerieModel) {
        apiService.updateSerie(id.toString(), serie)
    }

    // Método para eliminar una serie
    suspend fun deleteSerie(id: Int) {
        apiService.deleteSerie(id.toString())
    }
}
