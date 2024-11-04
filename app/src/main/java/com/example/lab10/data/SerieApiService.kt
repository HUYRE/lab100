package com.example.lab10.data
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface SerieApiService {
    // Método para obtener la lista de series
    @GET("serie") //http://127.0.0.1:8000/series
    suspend fun selectSeries(): List<SerieModel>

    // Método para obtener una serie específica por ID
    @GET("serie/{id}")
    suspend fun selectSerie(@Path("id") id: String): Response<SerieModel>

    // Método para crear una nueva serie
    @POST("serie")
    suspend fun insertSerie(@Body serie: SerieModel): Response<Void>

    // Método para actualizar una serie existente
    @PUT("serie/{id}")
    suspend fun updateSerie(@Path("id") id: String, @Body serie: SerieModel): Response<Void>

    // Método para eliminar una serie
    @DELETE("serie/{id}")
    suspend fun deleteSerie(@Path("id") id: String): Response<Void>
}