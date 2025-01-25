package com.beknur.testtask.navigation

import android.net.Uri
import com.beknur.testtask.domain.model.BinInfo

sealed class Screen(
	val route: String
) {

	object History : Screen("history")
	object Main:Screen("main")
	object Next : Screen("next/{binInfo}") {
		fun createRoute(binInfo: BinInfo): String {
			return "next/${binInfo}"
		}
	}
}
