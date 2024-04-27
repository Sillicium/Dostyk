//package com.example.myapplication.data_layer.module
//
//import com.example.myapplication.data_layer.network.AppBaseURLS
//import com.example.myapplication.data_layer.network.apiService.MainApiService
//import com.example.myapplication.data_layer.network.repo.data_store.BaseDataStoreRepo
//import com.example.myapplication.data_layer.network.sessionManager.auth.AuthenticationSessionManager
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Named
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object ClientInterceptorModule {
////    Network Interceptor Setup
//
//    @Singleton
//    @Provides
//    @Named("AuthBasicRefreshOkHttp")
//    fun addOnRefreshInterceptor(
//        it: Interceptor.Chain
//    ): Response {
////        val clientID = when(getAppType()){
////            APP_TYPES.client -> ClientHeaders.CLIENT_ID
////            APP_TYPES.merchant -> MerchantHeaders.CLIENT_ID
////        }
////
////        val clientSecret = when(getAppType()){
////            APP_TYPES.client -> ClientHeaders.CLIENT_SECRET
////            APP_TYPES.merchant -> MerchantHeaders.CLIENT_SECRET
////        }
//
//        val request = it.request().newBuilder()
////            .addHeader(GeneralHeaders.CLIENT_SECRET_HEADER_NAME, clientSecret)
////            .addHeader(GeneralHeaders.CLIENT_ID_HEADER_NAME, clientID)
//            .build()
//        return it.proceed(request)
//    }
//
//    // circulation error otherwise: okHttp -> Interceptor -> SessManager -> MerchRepo WHICH NEEDS okHttp
//    @Singleton
//    @Provides
//    @Named("AuthOnRefreshOkHttp")
//    fun provideClientOnRefreshOkHttp(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(this::addOnRefreshInterceptor)
//            .addInterceptor(BaseModule.provideLoggingInterceptor())
//            .build()
//    }
//
//
//    @Provides
//    @Singleton
//    @Named("AuthOnRefreshRetrofit")
//    fun provideOnRefreshRetrofit(
//        @Named("AuthOnRefreshOkHttp") okHttpClient: OkHttpClient
//    ): Retrofit {
//        return Retrofit.Builder()
//            //TODO CHANGE BASE SERVER URL
//            .baseUrl(AppBaseURLS.SERVER_BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    @Named("AuthOnRefreshApi")
//    fun provideOnRefreshApi(
//        @Named("AuthOnRefreshRetrofit") retrofit: Retrofit
//    ): MainApiService {
//        return retrofit.create(MainApiService::class.java)
//    }
//
//    // SessionManager ----------------------------------------------------------------------------
//    @Singleton
//    @Provides
//    fun provideAuthSessionManager(
//        appSharedPreferences: BaseDataStoreRepo,
//        @Named("AuthOnRefreshApi") mainApiService: MainApiService
//    ): AuthenticationSessionManager = AuthenticationSessionManager(
//        pref = appSharedPreferences,
//        apiService = mainApiService
//    )
//}