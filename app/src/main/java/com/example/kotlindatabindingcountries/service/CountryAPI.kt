package com.example.kotlindatabindingcountries.service

import com.example.kotlindatabindingcountries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    // GET -> POST

    //BASE_URL -> https://raw.githubusercontent.com/
    //EXT -> atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries() : Single<List<Country>>

}