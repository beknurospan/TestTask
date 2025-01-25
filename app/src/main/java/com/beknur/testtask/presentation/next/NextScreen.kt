package com.beknur.testtask.presentation.next

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.getApplicationComponent
import com.beknur.testtask.presentation.SharedViewModel
import com.beknur.testtask.presentation.history.HistoryItem


@Composable
fun NextScreen(){
	
	val viewModel:SharedViewModel= viewModel(factory = getApplicationComponent().getViewModelFactory())
	val binInfo=viewModel.binInfo
	HistoryItem(binInfo = binInfo)

}