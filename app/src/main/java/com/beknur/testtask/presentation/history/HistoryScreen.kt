package com.beknur.testtask.presentation.history

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.beknur.testtask.domain.model.BinInfo
import com.beknur.testtask.getApplicationComponent


@Composable
fun HistoryScreen() {

	val component = getApplicationComponent()
	val viewModel: HistoryViewModel = viewModel(factory = component.getViewModelFactory())

	val cards = viewModel.cards.collectAsState()
	val isLoading = viewModel.isLoading.collectAsState()

	if (isLoading.value) {
		CircularProgressIndicator(modifier = Modifier.fillMaxSize(), color = Color.Cyan)
	} else {

		LazyColumn(modifier = Modifier.fillMaxSize()) {
			items(cards.value) { binInfo ->
				HistoryItem(binInfo = binInfo)
			}
		}
	}
}


@Composable
fun HistoryItem(binInfo: BinInfo?) {
	val context = LocalContext.current

	val openMapLauncher =
		rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
			if (result.resultCode != Activity.RESULT_OK) {

			}
		}


	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {
		Column(modifier = Modifier.padding(16.dp)) {

			Text("Scheme: ${binInfo?.scheme}", fontWeight = FontWeight.Bold)
			Text("Type Card: ${binInfo?.type}", fontWeight = FontWeight.Bold)

			Text(
				text = "Coordinates: ${binInfo?.country?.latitude}, ${binInfo?.country?.longitude}",
				modifier = Modifier.clickable {
					val latitude = binInfo?.country?.latitude
					val longitude = binInfo?.country?.longitude
					if (latitude != null && longitude != null) {
						val uri =
							Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude")
						val intent = Intent(Intent.ACTION_VIEW, uri).apply {
							setPackage("com.google.android.apps.maps")
						}
						openMapLauncher.launch(intent)
					}
				}
			)

			Text("Brand: ${binInfo?.brand}", fontWeight = FontWeight.Bold)


			Text("Country: ${binInfo?.country?.name}", fontWeight = FontWeight.Bold)
		}
	}
}