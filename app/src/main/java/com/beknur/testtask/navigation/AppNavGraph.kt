package com.beknur.testtask.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.presentation.history.HistoryScreen
import com.beknur.testtask.presentation.main.MainScreen
import com.beknur.testtask.presentation.next.NextScreen
import com.google.gson.Gson

@Composable
fun AppNavigation(navController: NavHostController) {
	NavHost(
		navController = navController,
		startDestination = Screen.Main.route
	) {
		composable(Screen.Main.route) {
			MainScreen(
				navController,
				onButtonHistoryClicked
				= {
					navController.navigate(Screen.History.route)
				}
			)
		}
		composable(Screen.Next.route) {
			NextScreen()
		}
		composable(Screen.History.route) {
			HistoryScreen()
		}
	}
}