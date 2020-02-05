package com.visual.flickerdemo

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AppScopeModule {

    @Provides
    @AppScope
    fun provideRetrofitClient(): Retrofit {

        return RetrofitClient.create()
    }

    @Provides
    @AppScope
    fun provideImageService(retrofit: Retrofit): ImageService {

        return retrofit.create(ImageService::class.java)
    }
}