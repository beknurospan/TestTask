package com.beknur.testtask.presentation.history

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beknur.testtask.data.local.entity.BinInfoEntity
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.domain.usecases.GetHistoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext


class HistoryViewModel @Inject constructor(
	private val getHistoryUseCase: GetHistoryUseCase,
) : ViewModel() {


	private val _cards = MutableStateFlow<List<BinInfo>>(emptyList())
	val cards: StateFlow<List<BinInfo>> = _cards.asStateFlow()

	private val _isLoading = MutableStateFlow(false)
	val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

	init {
		loadCards()
	}

	private fun loadCards() {
		viewModelScope.launch {
			try {
				_isLoading.value = true
				val history = withContext(Dispatchers.IO) {
					getHistoryUseCase()
				}


				_cards.value = history
			} catch (e: Exception) {
				_cards.value = emptyList()
			} finally {
				_isLoading.value = false
			}
		}
	}

}

