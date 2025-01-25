package com.beknur.testtask.domain.repository

import com.beknur.testtask.domain.model.BinInfo
import kotlinx.coroutines.flow.Flow

interface BinInfoLocalRepository {
	suspend fun getAllCards(): List<BinInfo>
	suspend fun saveCard(binInfo: BinInfo)
}