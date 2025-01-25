package com.beknur.testtask.presentation.main


import android.util.Log

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.beknur.testtask.R
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.getApplicationComponent
import com.beknur.testtask.navigation.Screen
import com.beknur.testtask.presentation.SharedViewModel


@Composable
fun MainScreen(navHostController: NavHostController,onButtonHistoryClicked:()->Unit) {
	val component= getApplicationComponent()
	val viewModel:MainViewModel= viewModel(factory = component.getViewModelFactory())
	val sharedViewModel:SharedViewModel=viewModel(factory = component.getViewModelFactory())
	LaunchedEffect(Unit) {
		viewModel.navigateToNextScreen.collect { scheme ->
			sharedViewModel.addBin(scheme)
			navHostController.navigate(Screen.Next.route)
		}
	}
	val errorMessage = viewModel.errorMessage.collectAsState(initial = "")



	CardScreen(navHostController = navHostController, viewModel =viewModel,errorMessage=errorMessage,onButtonHistoryClicked )

}


@Composable
fun CardScreen(navHostController: NavHostController,viewModel: MainViewModel,errorMessage:State<String>,onButtonHistoryClicked: () -> Unit) {
	var text by remember { mutableStateOf("") }

	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(Color(0xFFF0E9AD)),
		contentAlignment = Alignment.Center
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {

			CardHold(text = text, onTextChange = { text = it },errorMessage=errorMessage)

			Spacer(modifier = Modifier.height(16.dp))

			Button(
				onClick = {

					viewModel.onButtonShowDetailsClicked(text)

				},
				shape = RoundedCornerShape(8.dp),
				colors = ButtonDefaults.buttonColors(
					containerColor = Color(0xFF56EC4B),
					contentColor = Color.White
				),
				modifier = Modifier.border(
					BorderStroke(4.dp, Color(0xFF171817)),
					shape = RoundedCornerShape(12.dp)
				)
			) {
				Text(
					stringResource(R.string.show_details),
					fontFamily = FontFamily.SansSerif,
					fontWeight = FontWeight.Bold
				)
			}
			Spacer(modifier = Modifier.height(8.dp))
			Button(
				onClick = {

					onButtonHistoryClicked()

				},
				shape = RoundedCornerShape(8.dp),
				colors = ButtonDefaults.buttonColors(
					containerColor = Color(0xFF56EC4B),
					contentColor = Color.White
				),
				modifier = Modifier.border(
					BorderStroke(4.dp, Color(0xFF171817)),
					shape = RoundedCornerShape(12.dp)
				)
			) {
				Text(
					text= stringResource(R.string.history),
					fontFamily = FontFamily.SansSerif,
					fontWeight = FontWeight.Bold
				)
			}
		}
	}
}

@Composable
private fun CardHold(text: String, onTextChange: (String) -> Unit,errorMessage: State<String>) {

	if (errorMessage.value.isNotEmpty()) {

		Text(text = errorMessage.value, color = Color.Red)
	}
	Card(
		backgroundColor = Color(0xFF6293BE),
		modifier = Modifier
			.size(height = 200.dp, width = 300.dp),
		elevation = 10.dp,
		shape = RoundedCornerShape(16.dp)
	) {
		Text(
			text = stringResource(R.string.card_number),
			modifier = Modifier.offset(x = 20.dp, y = 50.dp),
			fontWeight = FontWeight.Bold
		)

		Box(
			modifier = Modifier.fillMaxSize(),
			contentAlignment = Alignment.Center
		) {
			TextField(
				value = text,
				onValueChange = { onTextChange(it) },
				keyboardOptions = KeyboardOptions.Default.copy(
					keyboardType = KeyboardType.Number
				),
				modifier = Modifier
					.fillMaxWidth()
					.padding(start = 15.dp, end = 15.dp),
				label = { Text("00000000") }
			)
		}
	}
}


