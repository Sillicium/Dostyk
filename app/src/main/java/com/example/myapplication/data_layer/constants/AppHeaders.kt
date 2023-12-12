//package com.example.myapplication.data_layer.constants
//
//import android.content.Context
//import android.content.ContextWrapper
//import android.content.res.Configuration
//import android.content.res.Resources
//import com.example.myapplication.BuildConfig
//import com.example.myapplication.data_layer.network.BuildTypes
//import java.util.Locale
//
//
//object Headers {
//
//    val CLIENT_SECRET = when (BuildConfig.BUILD_TYPE) {
//        BuildTypes.release.name -> {
//            BuildConfig.MERCHANT_APP_PROD_CLIENT_SECRET
//        }
////        BuildTypes.qa.name -> {
////            BuildConfig.MERCHANT_APP_QA_CLIENT_SECRET
////        }
//        else -> {
//            BuildConfig.MERCHANT_APP_DEV_CLIENT_SECRET
//        }
//    }
//
//    val CLIENT_ID = when (BuildConfig.BUILD_TYPE) {
//        BuildTypes.release.name -> {
//            BuildConfig.MERCHANT_APP_PROD_CLIENT_ID
//        }
////        BuildTypes.qa.name -> {
////            BuildConfig.MERCHANT_APP_QA_CLIENT_ID
////        }
//        else -> {
//            BuildConfig.MERCHANT_APP_DEV_CLIENT_ID
//        }
//    }
//}
//
//object ClientHeaders{
//    val CLIENT_SECRET = when (BuildConfig.BUILD_TYPE) {
//        BuildTypes.release.name -> {
//            BuildConfig.CLIENT_APP_PROD_CLIENT_SECRET
//        }
////        BuildTypes.qa.name -> {
////            BuildConfig.CLIENT_APP_QA_CLIENT_SECRET
////        }
//        else -> {
//            BuildConfig.CLIENT_APP_DEV_CLIENT_SECRET
//        }
//    }
//
//    val CLIENT_ID = when (BuildConfig.BUILD_TYPE) {
//        BuildTypes.release.name -> {
//            BuildConfig.CLIENT_APP_PROD_CLIENT_ID
//        }
//        BuildTypes.qa.name -> {
//            BuildConfig.CLIENT_APP_QA_CLIENT_ID
//        }
//        else -> {
//            BuildConfig.CLIENT_APP_DEV_CLIENT_ID
//        }
//    }
//}
//
//enum class AppLocales{
//    en, vi
//}
//
//object GeneralHeaders{
//    const val CLIENT_SECRET_HEADER_NAME = "Client-Secret"
//    const val CLIENT_ID_HEADER_NAME = "Client-ID"
//
//    const val LOCALE_HEADER = "locale"
//
//    private var current_locale = AppLocales.en.name
//    val CURRENT_LOCALE
//        get() = current_locale
//
//    fun setNewLocale(locale: AppLocales){
//        current_locale = locale.name
//    }
//
//
//    const val LAT_HEADER = "lat"
//    const val LNG_HEADER = "lng"
//}
//
//object LanguageConfig {
//    fun changeLanguage(context: Context, languageCode: String): ContextWrapper {
//        var context: Context = context
//        val resources: Resources = context.resources
//        val configuration: Configuration = resources.configuration
//        val systemLocale: Locale = configuration.locales.get(0)
//
//        if (languageCode != "" && !systemLocale.language.equals(languageCode)) {
//            val locale = Locale(languageCode)
//            Locale.setDefault(locale)
//            configuration.setLocale(locale)
//
//            context = context.createConfigurationContext(configuration)
//        }
//        return ContextWrapper(context)
//    }
//}