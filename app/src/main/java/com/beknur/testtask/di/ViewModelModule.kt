package com.beknur.testtask.di

import androidx.lifecycle.ViewModel
import com.beknur.testtask.presentation.SharedViewModel
import com.beknur.testtask.presentation.history.HistoryViewModel
import com.beknur.testtask.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
interface ViewModelModule {
	@IntoMap
	@ViewModelKey(HistoryViewModel::class)
	@Binds
	fun binHistoryViewModel(impl:HistoryViewModel):ViewModel

	@IntoMap
	@ViewModelKey(MainViewModel::class)
	@Binds
	fun binMainViewModel(impl: MainViewModel):ViewModel


	@IntoMap
	@Singleton
	@ViewModelKey(SharedViewModel::class)
	@Binds
	fun binSharedViewModel(impl: SharedViewModel):ViewModel

}