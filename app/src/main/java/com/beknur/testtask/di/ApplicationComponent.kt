package com.beknur.testtask.di

import android.content.Context
import com.beknur.testtask.presentation.ViewModelFactory
import com.beknur.testtask.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Singleton
@Singleton
@ApplicationScope

@Component(    modules = [
	DataModule::class,
	ViewModelModule::class
])

interface ApplicationComponent {

	fun getViewModelFactory(): ViewModelFactory
	fun inject(activity: MainActivity)

	@Component.Factory
	interface Factory {

		fun create(
			@BindsInstance context: Context
		): ApplicationComponent
	}
}