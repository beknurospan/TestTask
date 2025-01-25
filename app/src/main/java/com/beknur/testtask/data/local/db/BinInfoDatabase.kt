package com.beknur.testtask.data.local.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.beknur.testtask.data.local.entity.BinInfoEntity

import android.content.Context
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [BinInfoEntity::class], version = 2, exportSchema = false)
abstract class BinInfoDatabase : RoomDatabase() {
	abstract fun binInfoDao(): BinInfoDao

	companion object {
		@Volatile
		private var INSTANCE: BinInfoDatabase? = null

		fun getInstance(context: Context): BinInfoDatabase {
			return INSTANCE ?: synchronized(this) {
				val instance = Room.databaseBuilder(
					context.applicationContext,
					BinInfoDatabase::class.java,
					"bin_info_db"
				).build()
				INSTANCE = instance
				instance
			}
		}
	}
}
