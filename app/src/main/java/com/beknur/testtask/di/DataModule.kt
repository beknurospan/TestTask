package com.beknur.testtask.di

import android.content.Context
import com.beknur.testtask.data.local.db.BinInfoDao
import com.beknur.testtask.data.local.db.BinInfoDatabase
import com.beknur.testtask.data.network.api.ApiFactory
import com.beknur.testtask.data.network.api.ApiService
import com.beknur.testtask.data.repository.BinInfoLocalRepositoryImpl
import com.beknur.testtask.data.repository.BinInfoRemoteRepositoryImpl
import com.beknur.testtask.domain.repository.BinInfoLocalRepository
import com.beknur.testtask.domain.repository.BinInfoRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
	@[ApplicationScope Binds]
	fun bindBinInfoRemoteRepository(impl: BinInfoRemoteRepositoryImpl): BinInfoRemoteRepository

	@[ApplicationScope Binds]
	fun bindBinInfoLocalRepository(impl: BinInfoLocalRepositoryImpl): BinInfoLocalRepository

	companion object {

		@[ApplicationScope Provides]
		fun provideApiService(): ApiService = ApiFactory.apiService

		@[ApplicationScope Provides]
		fun provideBinInfoDatabase(context: Context): BinInfoDatabase {
			return BinInfoDatabase.getInstance(context)
		}

		@[ApplicationScope Provides]
		fun provideBinInfoDao(database: BinInfoDatabase): BinInfoDao {
			return database.binInfoDao()
		}
	}
}