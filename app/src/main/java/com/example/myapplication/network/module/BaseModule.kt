package com.example.myapplication.network.module


import com.example.myapplication.BuildConfig
import com.example.myapplication.network.TEST_URL
import com.example.myapplication.network.repo.TestRepository
import com.example.myapplication.network.repo.TestRepositoryImpl
import com.example.myapplication.network.service.TestApiService
import dagger.Module
import dagger.Provides
import javax.inject.Named
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BaseModule {

    @Singleton
    @Provides
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }
    }


    //    Test Part -----------------------------------------------------------------

    //Network layer
    @Singleton
    @Provides
    @Named("TestOkHttp")
    fun provideTestOkHttp(
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    @Named("TestRetrofit")
    fun provideTestRetrofit(
        @Named("TestOkHttp") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
//                TODO use ClientAppUrl
            .baseUrl(TEST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideTestRepo(apiService: TestApiService)
            : TestRepository {
        return TestRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideTestApiClient(@Named("TestRetrofit") retrofit: Retrofit): TestApiService {
        return retrofit.create(TestApiService::class.java)
    }

}