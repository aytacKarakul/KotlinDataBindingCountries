package com.example.kotlindatabindingcountries.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("capital")
    val countryCapital: String?,
    @SerializedName("region")
    val countryRegion: String?,
    @SerializedName("currency")
    val countryCurrency: String?,
    @SerializedName("flag")
    val imageUrl: String?,
    @SerializedName("language")
    val countryLanguage: String?){

    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0

}