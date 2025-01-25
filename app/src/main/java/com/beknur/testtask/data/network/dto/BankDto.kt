package com.beknur.testtask.data.network.dto

import com.google.gson.annotations.SerializedName

data class BankDto (
	@SerializedName("name") val name: String
)