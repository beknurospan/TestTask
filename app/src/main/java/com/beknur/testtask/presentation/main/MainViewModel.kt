package com.beknur.testtask.presentation.main

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.testtask.data.mapper.toBinInfoEntity
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.domain.usecases.GetBinInfoUseCase
import com.beknur.testtask.domain.usecases.GetHistoryUseCase
import com.beknur.testtask.domain.usecases.SaveCardUseCase
import com.beknur.testtask.navigation.Screen
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class MainViewModel @Inject constructor(
	private val saveCardUseCase: SaveCardUseCase,
	private val getBinInfoUseCase: GetBinInfoUseCase
) : ViewModel() {
	private val _navigateToNextScreen = MutableSharedFlow<BinInfo>()
	val navigateToNextScreen: SharedFlow<BinInfo> = _navigateToNextScreen.asSharedFlow()
	private val _errorMessage = MutableSharedFlow<String>()
	val errorMessage: SharedFlow<String> = _errorMessage.asSharedFlow()

	fun onButtonShowDetailsClicked(input: String) {
		viewModelScope.launch {
			try {

				val inputs = input.trim()

				if (isValidBin(inputs)) {
					val binInfo = getBinInfoUseCase(inputs)

					withContext(Dispatchers.IO) {
						saveCardUseCase(binInfo)

					}
					_navigateToNextScreen.emit(binInfo)

				} else {
					_errorMessage.emit("6 8 digits should be")
				}


			} catch (e: HttpException) {
				if (e.code() == 429) {

					_errorMessage.emit("You have exceeded the rate limit of 5 requests/hour. Please wait a bit and try again.")
				}
			} catch (b: NullPointerException) {
				_errorMessage.emit("No Info with this num")
			} catch (e: Exception) {
				Log.e("MainViewModel", "Failed to save BIN info", e)
			}
		}
	}


	private fun isValidBin(input: String): Boolean {

		val sanitizedInput = input.replace(" ", "")
		if (sanitizedInput.length == 7) return false
		return sanitizedInput.length in 6..8 && sanitizedInput.all { it.isDigit() }
	}
}