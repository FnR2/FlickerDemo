package com.visual.flickerdemo

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit


@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideRetrofitClient(): Retrofit {

            return RetrofitClient.create()
        }


        @JvmStatic
        @Provides
        fun provideImageService(retrofit: Retrofit): ImageService {

            return retrofit.create(ImageService::class.java)
        }


        @JvmStatic
        @Provides
        fun provideImageMapper(context: Context): ImageMapper {
            return ImageMapper(context)
        }


        @JvmStatic
        @Provides
        fun provideImageRepository(imageService: ImageService): ImageRepository {
            return ImageRepository(imageService)
        }


        @JvmStatic
        @Provides
        fun provideViewModelFactory(
            imageRepository: ImageRepository,
            imageMapper: ImageMapper
        ): ImageViewModelFactory {
            return ImageViewModelFactory(imageRepository, imageMapper)
        }


        @JvmStatic
        @Provides
        fun provideContext(application: Application) = application.applicationContext


    }

}