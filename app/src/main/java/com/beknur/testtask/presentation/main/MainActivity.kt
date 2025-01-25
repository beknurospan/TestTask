package com.beknur.testtask.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.beknur.testtask.TestApp
import com.beknur.testtask.navigation.AppNavigation
import com.beknur.testtask.ui.theme.TestTaskTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		(applicationContext as TestApp).applicationComponent.inject(this)
		super.onCreate(savedInstanceState)
		setContent {
			TestTaskTheme {
				val navController = rememberNavController()
				AppNavigation(navController)
			}
		}
	}
}

