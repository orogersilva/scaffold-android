package com.orogersilva.scaffoldandroid.networking.di

import android.content.Context
import com.orogersilva.scaffoldandroid.networking.BuildConfig
import com.orogersilva.scaffoldandroid.networking.api.ScaffoldAndroidApiClient
import com.orogersilva.scaffoldandroid.networking.rest.RestClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScaffoldAndroidApiClientModule {

    @Provides
    @Singleton
    fun provideScaffoldAndroidApiClient(
        @ApplicationContext context: Context
    ): ScaffoldAndroidApiClient =
        RestClient.getApiClient(
            context,
            ScaffoldAndroidApiClient::class.java,
            BuildConfig.BASE_API_URL
        )
}
