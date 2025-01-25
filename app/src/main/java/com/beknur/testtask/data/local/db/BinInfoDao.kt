package com.beknur.testtask.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomWarnings
import com.beknur.testtask.data.local.entity.BinInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BinInfoDao {
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insert(binInfo: BinInfoEntity)

	@Query("SELECT * FROM bin_info")
	fun getAll(): List<BinInfoEntity>
}
