package com.beknur.testtask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Country(
	val numeric: String,
	val alpha2: String,
	val name: String,
	val emoji: String,
	val currency: String,
	val latitude: Double,
	val longitude: Double
):Parcelable