package com.beknur.testtask.data.mapper

import com.beknur.testtask.data.local.entity.BinInfoEntity
import com.beknur.testtask.data.network.dto.BankDto
import com.beknur.testtask.data.network.dto.BinInfoDto

import com.beknur.testtask.data.network.dto.CountryDto
import com.beknur.testtask.domain.model.Bank
import com.beknur.testtask.domain.model.BinInfo

import com.beknur.testtask.domain.model.Country
import com.google.gson.Gson

fun BinInfoDto.toBinInfo(): BinInfo = BinInfo(

	scheme = this.scheme,
	type = this.type,
	brand = this.brand,
	country = this.country.toCountry(),
	bank = this.bank.toBank()
)


fun CountryDto.toCountry(): Country = Country(
	numeric = this.numeric,
	alpha2 = this.alpha2,
	name = this.name,
	emoji = this.emoji,
	currency = this.currency,
	latitude = this.latitude,
	longitude = this.longitude
)
fun BankDto.toBank(): Bank = Bank(
	name = this.name,

)



fun BinInfo.toBinInfoEntity(): BinInfoEntity {
	val gson = Gson()

	return BinInfoEntity(

		scheme = this.scheme,
		type = this.type,
		brand = this.brand,
		countryJson = gson.toJson(this.country),
		bankJson = gson.toJson(this.bank)
	)
}
fun BinInfoEntity.toBinInfo(): BinInfo {
	val gson = Gson()

	return BinInfo(

		scheme = this.scheme,
		type = this.type,
		brand = this.brand,
		country = gson.fromJson(this.countryJson, Country::class.java),
		bank = gson.fromJson(this.bankJson, Bank::class.java)
	)
}



