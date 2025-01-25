package com.beknur.testtask.domain.repository

import com.beknur.testtask.domain.model.BinInfo

interface BinInfoRemoteRepository {
	suspend fun getBinInfo(bin: String):BinInfo
}