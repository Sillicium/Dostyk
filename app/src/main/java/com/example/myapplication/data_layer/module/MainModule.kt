package com.example.myapplication.data_layer.module

import com.example.myapplication.data_layer.network.AppBaseURLS
import com.example.myapplication.data_layer.network.apiService.MainApiService
import com.example.myapplication.data_layer.network.sessionManager.auth.AuthenticationSessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    //    Provide DataStores
    @Provides
    @Singleton
    @Named("MainInterceptor")
    fun provideMainInterceptor(
        sessionManager: AuthenticationSessionManager
    ): BaseAuthInterceptor = AuthInterceptorImpl(sessionManager = sessionManager)


    @Singleton
    @Provides
    @Named("MainOkHttp")
    fun provideMainOkHttp(
        @Named("MainInterceptor") interceptor: BaseAuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
//           make logger last!
            .addInterceptor(BaseModule.provideLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    @Named("MainRetrofit")
    fun provideMainRetrofit(
        @Named("MainOkHttp") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppBaseURLS.SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    @Named("MainApi")
    fun provideMainApi(
        @Named("MainRetrofit") authRetrofit: Retrofit
    ): MainApiService {
        return authRetrofit.create(MainApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideMainRepository(
        @Named("MainApi") apiService: MainApiService
    ): MainRepository =  MainRepositoryImpl(apiService)
}