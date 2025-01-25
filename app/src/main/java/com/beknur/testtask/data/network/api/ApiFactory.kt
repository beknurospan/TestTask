package com.beknur.testtask.data.network.api

import retrofit2.create



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

	private const val BASE_URL = "https://lookup.binlist.net/"


	private val retrofit: Retrofit by lazy {
		Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}


	val apiService:ApiService=retrofit.create()

}
