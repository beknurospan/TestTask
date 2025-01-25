package com.beknur.testtask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.beknur.testtask.domain.model.BinInfo

@Entity(tableName = "bin_info")
data class BinInfoEntity(
	@PrimaryKey(autoGenerate = true) val id: Int = 0,
	val scheme: String,
	val type: String,
	val brand: String,
	val countryJson: String,
	val bankJson: String
)
