package com.beknur.testtask.domain.usecases

import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.domain.repository.BinInfoLocalRepository
import javax.inject.Inject

class SaveCardUseCase @Inject constructor(
	private val repository: BinInfoLocalRepository
) {
	suspend operator fun invoke(binInfo: BinInfo) {
		repository.saveCard(binInfo)
	}
}