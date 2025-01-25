package com.beknur.testtask.data.repository

import com.beknur.testtask.data.local.db.BinInfoDao
import com.beknur.testtask.data.mapper.toBinInfo
import com.beknur.testtask.data.mapper.toBinInfoEntity
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.domain.repository.BinInfoLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BinInfoLocalRepositoryImpl @Inject constructor(
	private val binInfoDao:BinInfoDao
) : BinInfoLocalRepository {
	override suspend fun getAllCards(): List<BinInfo> {
		return binInfoDao.getAll().map { it.toBinInfo() }
	}

	override suspend fun saveCard(binInfo: BinInfo) {
		binInfoDao.insert(binInfo.toBinInfoEntity())
	}


}