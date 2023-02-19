package com.hanncompose.gamecompose.di

import com.hanncompose.gamecompose.common.Constants
import com.hanncompose.gamecompose.data.remote.GameaApi
import com.hanncompose.gamecompose.data.repository.GameRepository
import com.hanncompose.gamecompose.domain.repository.IGameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGameApi() : GameaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGameRepository(api:GameaApi) : IGameRepository {
        return GameRepository(api)
    }

}