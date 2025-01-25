package com.beknur.testtask.data.repository

import com.beknur.testtask.data.mapper.toBinInfo
import com.beknur.testtask.data.network.api.ApiService
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.domain.repository.BinInfoRemoteRepository
import javax.inject.Inject


class BinInfoRemoteRepositoryImpl @Inject constructor(
	private val apiService: ApiService
):BinInfoRemoteRepository {
	override suspend fun getBinInfo(bin: String): BinInfo {

		return  apiService.getBinInfo(bin).toBinInfo()
	}
}