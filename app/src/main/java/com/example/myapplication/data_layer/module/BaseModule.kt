package com.example.myapplication.data_layer.module

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.myapplication.BuildConfig
import com.example.myapplication.data_layer.network.AppBaseURLS
import com.example.myapplication.data_layer.network.TEST_URL
import com.example.myapplication.data_layer.network.apiService.MainApiService
import com.example.myapplication.data_layer.network.repo.TestRepository
import com.example.myapplication.data_layer.network.repo.TestRepositoryImpl
import com.example.myapplication.data_layer.network.repo.data_store.BaseDataStoreRepo
import com.example.myapplication.data_layer.network.sessionManager.auth.SessionDataStoreRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
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

    //    Provides basic DATASTORE<Preferences>, that is unique for each app!
    @Provides
    @Singleton
    fun provideDataStorePreferences(
        @ApplicationContext applicationContext: Context
    ): DataStore<Preferences> {
        return applicationContext.generalUserDataStore
    }

    //    Provide DataStores --------------------------------------------------------------------

    @Provides
    @Singleton
    fun provideDataStoreRepo(
        userDataStorePreferences: DataStore<Preferences>
    ): BaseDataStoreRepo {
        return SessionDataStoreRepoImpl(userDataStorePreferences)
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
            .baseUrl(AppBaseURLS.SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideTestRepo(apiService: MainApiService)
            : TestRepository {
        return TestRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideTestApiClient(@Named("TestRetrofit") retrofit: Retrofit): MainApiService {
        return retrofit.create(MainApiService::class.java)
    }

}