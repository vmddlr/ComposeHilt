package com.example.corrutinasflow.di

import com.example.corrutinasflow.data.network.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InstanceModule {

    @Singleton
    @Provides
    fun interceptor() = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }


    @Singleton
    @Provides
    fun provideClient(interceptor: HttpLoggingInterceptor) = OkHttpClient
        .Builder()
        .addNetworkInterceptor(interceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient) =
        Retrofit
            .Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Singleton
    @Provides
    fun provideWeather(retrofit: Retrofit) =
        retrofit.create(WeatherApi::class.java)

}