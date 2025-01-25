package com.beknur.testtask.domain.usecases


import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.domain.repository.BinInfoLocalRepository
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
	private val repository: BinInfoLocalRepository
) {
	suspend operator fun invoke():List<BinInfo> {
		return repository.getAllCards()
	}
}