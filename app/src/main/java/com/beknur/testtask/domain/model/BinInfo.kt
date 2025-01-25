package com.beknur.testtask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class BinInfo(

	val scheme: String,
	val type: String,
	val brand: String,
	val country: Country,
	val bank: Bank
):Parcelable
