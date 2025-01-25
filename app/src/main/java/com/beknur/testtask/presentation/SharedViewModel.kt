package com.beknur.testtask.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.beknur.testtask.domain.model.BinInfo
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class SharedViewModel @Inject constructor():ViewModel() {
	var binInfo by mutableStateOf<BinInfo?>(null)
		private set

	fun addBin(newBinInfo: BinInfo){
		binInfo=newBinInfo
	}

}