package com.beknur.testtask.data.network.dto

import com.google.gson.annotations.SerializedName

data class CountryDto(
	@SerializedName("numeric") val numeric: String,
	@SerializedName("alpha2") val alpha2: String,
	@SerializedName("name") val name: String,
	@SerializedName("emoji") val emoji: String,
	@SerializedName("currency") val currency: String,
	@SerializedName("latitude") val latitude: Double,
	@SerializedName("longitude") val longitude: Double
)