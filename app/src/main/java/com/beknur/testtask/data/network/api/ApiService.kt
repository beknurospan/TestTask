package com.beknur.testtask.data.network.api

import com.beknur.testtask.data.network.dto.BinInfoDto
import com.beknur.testtask.domain.model.BinInfo
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
	@GET("{bin}")
	suspend fun getBinInfo(
		@Path("bin") bin: String,
		@Header("Accept-Version") version: String = "3"
	): BinInfoDto
}


