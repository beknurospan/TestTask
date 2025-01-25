package com.beknur.testtask

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.beknur.testtask.di.ApplicationComponent
import com.beknur.testtask.di.DaggerApplicationComponent
import com.beknur.testtask.di.ViewModelModule

class TestApp:Application() {
	lateinit var applicationComponent: ApplicationComponent

	override fun onCreate() {
		super.onCreate()
		applicationComponent=DaggerApplicationComponent.factory().create(this)
	}
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
	Log.d("RECOMPOSITION_TAG", "getApplicationComponent")
	return (LocalContext.current.applicationContext as TestApp).applicationComponent
}
