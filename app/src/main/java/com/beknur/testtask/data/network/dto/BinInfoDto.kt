package com.beknur.testtask.data.network.dto

import com.google.gson.annotations.SerializedName

data class BinInfoDto(
	@SerializedName("scheme") val scheme: String,
	@SerializedName("type") val type: String,
	@SerializedName("brand") val brand: String,
	@SerializedName("country") val country: CountryDto,
	@SerializedName("bank") val bank: BankDto
)