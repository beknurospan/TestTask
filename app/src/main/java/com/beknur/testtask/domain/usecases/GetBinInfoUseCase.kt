package com.beknur.testtask.domain.usecases

import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.domain.repository.BinInfoLocalRepository
import com.beknur.testtask.domain.repository.BinInfoRemoteRepository
import javax.inject.Inject

class GetBinInfoUseCase @Inject constructor(
	private val repository: BinInfoRemoteRepository
) {
	suspend operator fun invoke(bin: String): BinInfo {
		return repository.getBinInfo(bin)
	}
}